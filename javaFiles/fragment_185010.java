// this map will have the required values
Map<String, List<Object>> newMap = new HashMap<String, List<Object>>();

for (Object propNameObject : map.keySet()) {
    count++;
    String propertyName = (String) propNameObject;
    Object property1 = propUtils.getProperty(oldObject, propertyName);
    Object property2 = propUtils.getProperty(newObject, propertyName);
    List<Object> tempList = new ArrayList<Object>();
    tempList.add(property1);
    tempList.add(property2);
    newMap.put(propertyName, tempList);
}