Map<String, MyObject> objMap = new HashMap<String, MyObject>();  
for (MyObject o : objectList) {
    if (objMap.containsKey(o.getId()) {
        objMap.get(o.getId()).setDuplicate(true);
        o.setDuplicate(true);
    } else {
        objMap.put(o.getId(), o);
    }
}