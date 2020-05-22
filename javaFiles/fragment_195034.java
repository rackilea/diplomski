private CacheMBean<String, Message> messageStorage = newJmxClient(  
    CacheMBean.class,   
    "com.my.company:type=cache,name=MessageCacheImpl",   
    "service:jmx:rmi:///jndi/rmi://<host>:<port>/karaf-root",   
    "smx",   
    "smx");
...
Message message = messageStorage.get(messageId);