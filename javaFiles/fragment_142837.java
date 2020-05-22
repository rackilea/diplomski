UIDefaults uiDefaults = UIManager.getDefaults();
Enumeration<Object> keys = uiDefaults.keys();
List<String> allUIManagerConfigs=  new ArrayList<>();

for(;keys.hasMoreElements();){
    Object key = keys.nextElement();
    String value = String.valueOf(key);
    allUIManagerConfigs.add(value);
}

Collections.sort(allUIManagerConfigs);

for(String keyName:allUIManagerConfigs){
    System.out.println(keyName);
}