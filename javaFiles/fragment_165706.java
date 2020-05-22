Map<String, MyObject> objMap = new HashMap<String, MyObject>();  
for (MyObject o : objectList) {
    if (objMap.containsKey(o.getId()) {
        MyObject other = objMap.get(o.getId());
        if (other != null) {
            othet.setDuplicate(true);
            objMap.put(o.getId(), null);
        }
        o.setDuplicate(true);
    } else {
        objMap.put(o.getId(), o);
    }
}