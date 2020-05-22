@Bean
public Config config(Environment environment) {
    Properties props = new Properties();
    props.put("hazelcast.group.name", environment.getProperty("hazelcast.group.name"));
    return new ClasspathXmlConfig("hazelcast.xml", props);
}