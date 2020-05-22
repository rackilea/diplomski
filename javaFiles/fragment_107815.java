package test.jmx.hornetq;

import org.hornetq.api.jms.management.JMSQueueControl;

import javax.management.*;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

public class WildflyJmsControl {

    public static void main(String[] args) {
        try {
            //Get a connection to the WildFly 8 MBean server on localhost
            String host = "localhost";
            int port = 9990;  // management-web port
            String urlString = System.getProperty("jmx.service.url","service:jmx:http-remoting-jmx://" + host + ":" + port);
            JMXServiceURL serviceURL = new JMXServiceURL(urlString);
            JMXConnector jmxConnector = JMXConnectorFactory.connect(serviceURL, null);
            MBeanServerConnection connection = jmxConnector.getMBeanServerConnection();

            String queueName = "testQueue"; // use your queue name here

            String mbeanObjectName = "jboss.as:subsystem=messaging,hornetq-server=default,jms-queue=" + queueName;
            ObjectName objectName = ObjectName.getInstance(mbeanObjectName);

            JMSQueueControl jmsQueueControl = (JMSQueueControl) MBeanServerInvocationHandler.newProxyInstance(connection, objectName, JMSQueueControl.class, false);
            assert jmsQueueControl != null;

            long msgCount = jmsQueueControl.countMessages(null);

            System.out.println(mbeanObjectName + " message count: " + msgCount);

            jmsQueueControl.pause();
            System.out.println("queue paused");

            jmsQueueControl.resume();
            System.out.println("queue resumed");

            jmxConnector.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}