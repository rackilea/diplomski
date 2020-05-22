public List<myObj> get(String hashName, string key) {
    Object map = redis.opsForHash().get(hashName,key);
    if (map==null) {
        log.info("no keys found");
        return new ArrayList<myObj>();
    }
    List<myObj> myList= mapper.convertValue(map, new TypeReference<List<myObj>(){});
    return Collections.unmodifiableList(myList);
}