JMXConnector jmxConnector = null;
            MBeanServerConnection mbeanConn = null;
            try {
                String url = "service:jmx:rmi:///jndi/rmi://" + this.server + ":" + this.port + "/jmxrmi";
                JMXServiceURL serviceUrl;

                serviceUrl = new JMXServiceURL(url);
                jmxConnector = JMXConnectorFactory.connect(serviceUrl, null);
                mbeanConn = jmxConnector.getMBeanServerConnection();
}catch(Exception e)
{
}
finally
{
//close jmx connector.
}