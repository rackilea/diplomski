import java.util.Hashtable;

private static String host = "dns.name";
private static int port = 1414;
private static String channel = "MQ.SVRCONN.CHL";

Hashtable properties = new Hashtable<String, Object>();
properties.put("hostname", host);
properties.put("port", port);
properties.put("channel", channel);

MQQueueManager qMgr = new MQQueueManager(qManager, properties);