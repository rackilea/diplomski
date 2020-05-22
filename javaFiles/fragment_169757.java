import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.management.MBeanServerConnection;
import javax.management.MBeanServerInvocationHandler;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQSession;
import org.apache.activemq.broker.jmx.BrokerViewMBean;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.apache.activemq.openwire.OpenWireFormat;
import org.apache.activemq.transport.TransportFilter;
import org.apache.activemq.transport.TransportListener;
import org.apache.activemq.transport.failover.FailoverTransport;
import org.apache.activemq.util.ByteSequence;

public class SimpleSenderMaxSizeManager {

    private static Connection conn = null;
    private static boolean transportChanged;
    private static Long MAX_FRAME_SIZE;

    public static void main(String[] args) throws JMSException {
        try {
            SimpleSenderMaxSizeManager.updateMaxSize("host1");
            ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory(
                    "failover:(tcp://host1:5670,tcp://host2:5671)?randomize=false");
            cf.setTransportListener(new TransportListener() {

                @Override
                public void transportResumed() {
                    if (transportChanged) {
                        transportChanged = false;
                        try {
                            SimpleSenderMaxSizeManager.updateMaxSize(null);
                        } catch (Exception e) {
                        }
                    }
                }

                @Override
                public void transportInterupted() {
                    transportChanged = true;
                }

                @Override
                public void onException(IOException error) {
                }

                @Override
                public void onCommand(Object command) {
                }
            });
            conn = cf.createConnection();
            ActiveMQSession session = (ActiveMQSession) conn.createSession(false,
                    ActiveMQSession.INDIVIDUAL_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer(session.createQueue("TEST"));
            conn.start();
            ActiveMQTextMessage msg = (ActiveMQTextMessage) session.createTextMessage("test");
            OpenWireFormat opf = new OpenWireFormat();
            opf.setTightEncodingEnabled(true);
            ByteSequence tab = opf.marshal(msg);
            System.out.println(tab.length);
            if (tab.length >= MAX_FRAME_SIZE) {
                throw new RuntimeException(tab.length + ">=" + MAX_FRAME_SIZE);
            }
            producer.send(msg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                }
            }
        }
    }

    protected static void updateMaxSize(String host) throws Exception {
        JMXConnector jmxc = null;
        try {
            String jmxHost = host;
            String scheme = null;
            if (conn == null) {
                scheme = "tcp";
            } else {
                org.apache.activemq.transport.TransportFilter responseCorrelator = (TransportFilter) ((ActiveMQConnection) conn)
                        .getTransport();
                TransportFilter mutexTransport = (TransportFilter) responseCorrelator.getNext();
                FailoverTransport failoverTransport = (FailoverTransport) mutexTransport.getNext();
                while (failoverTransport.getConnectedTransportURI() == null) {
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                    }
                }
                scheme = failoverTransport.getConnectedTransportURI().getScheme();
                jmxHost = failoverTransport.getConnectedTransportURI().getHost();
            }
            JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://" + jmxHost + ":1099/jmxrmi");
            Map<String, String[]> env = new HashMap<>();
            String[] creds = { "admin", "admin" };
            env.put(JMXConnector.CREDENTIALS, creds);
            jmxc = JMXConnectorFactory.connect(url, env);
            MBeanServerConnection conn = jmxc.getMBeanServerConnection();
            ObjectName activeMq = new ObjectName("org.apache.activemq:type=Broker,brokerName=localhost");
            BrokerViewMBean mbean = MBeanServerInvocationHandler.newProxyInstance(conn, activeMq, BrokerViewMBean.class,
                    true);
            String value = mbean.getTransportConnectorByType(scheme);
            String[] pairs = value.split("&");
            for (String pair : pairs) {
                if (pair.contains("wireFormat.maxFrameSize")) {
                    int idx = pair.indexOf("=");
                    System.out.println(URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
                    MAX_FRAME_SIZE = Long.valueOf(URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
                    MAX_FRAME_SIZE -= 1000;// security for JMS headers added by
                                            // session on sending
                }
            }
        } finally {
            if (jmxc != null) {
                try {
                    jmxc.close();
                } catch (Exception e) {
                }
            }
        }
    }
}