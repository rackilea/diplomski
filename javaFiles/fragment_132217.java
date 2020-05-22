public synchronized void add(String hashName, int key, myObj element) {
    List<myObj> myList;
    Object map = redis.opsForHash().get(hashName,key);
    if (map != null) {
        myList= mapper.convertValue(map, new TypeReference<List<myObj>(){});
    } else {
        myList = new ArrayList<myObj>();
    }
    myList.add(element);
    redis.opsForHash().put(hashName, String.valueOf(key), myList);
}