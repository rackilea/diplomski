package com.awgtek.miscpocs.lognfetch.client;

import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

public class TestJMXConn {

    public static void main(String[] args) throws Exception {
      JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:8600/jmxrmi");
      JMXConnector connect = JMXConnectorFactory.connect(url);
      MBeanServerConnection mbsc = connect.getMBeanServerConnection();
     // ObjectName o = new ObjectName("com.netflix.servo:name=countSuccess,type=HystrixCommand,instance=LogAndFetchRestServicePostCommand");
      ObjectName o = new ObjectName("com.netflix.servo:name=countSuccess,type=HystrixCommand,instance=LogAndFetchRestServiceGetCommand");
      Object value = mbsc.getAttribute(o, "value");
      System.out.println("the value: " + value);
      connect.close();


    }

}