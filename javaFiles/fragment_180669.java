MultiValueMap<String, String> testMap = new MultiValueMap<String, String>();
Iterator<Map.Entry<String, String>> iterator = testMap.iterator();
while (iterator.hasNext()){
    Map.Entry<String, String> pair = iterator.next();
    // do something
}