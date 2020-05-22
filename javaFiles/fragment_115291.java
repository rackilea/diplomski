public class MsgProDeactivator extends AbstractMediator { 

    public boolean mediate(MessageContext context) { 
        try {
            Map<String, Object> env = new HashMap<String, Object>();
            String[] credentials = new String[]{"admin", "admin"};
            env.put("jmx.remote.credentials", credentials);

            String url = "service:jmx:rmi://localhost:11111/jndi/rmi://localhost:9999/jmxrmi";
            JMXServiceURL target = new JMXServiceURL(url);
            JMXConnector connector = JMXConnectorFactory.connect(target, env);
            MBeanServerConnection remote = connector.getMBeanServerConnection();

            String beanDef = "org.apache.synapse:Type=Message Forwarding Processor view,Name=testPro";
            ObjectName bean = new ObjectName(beanDef);

            remote.invoke(bean, "deactivate", null, null);
            connector.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}