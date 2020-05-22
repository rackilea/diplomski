Map<String, String> configMap = new HashMap<String, String>();
for (ConfigurationNode c : node.getChildren("task"))
{
    String key = (String)c.getAttribute(0).getValue();
    String value = (String)c.getValue();
    configMap.put(key, value);
}