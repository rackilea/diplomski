import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import javax.management.Attribute;
import javax.management.MBeanServerConnection;
import javax.management.MBeanServerInvocationHandler;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

public class Client {

    public static void main(String[] args) {
        try {
            JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://servername:9010/jmxrmi");
            JMXConnector jmxc = JMXConnectorFactory.connect(url, null);

            MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();

            ObjectName replication1 = new ObjectName("com.adobe.granite.replication:type=agent,id=\"replication-publish-1\"");
            ObjectName replication2 = new ObjectName("com.adobe.granite.replication:type=agent,id=\"replication-publish-2\"");

            String replication1Status = mbsc.getAttribute(replication1, "QueuePaused").toString();
            String replication2Status = mbsc.getAttribute(replication2, "QueuePaused").toString();



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}