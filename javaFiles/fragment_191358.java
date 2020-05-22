public void increaseCountInFile(Integer hashCode) {
    if(map.containsKey(hashCode)) {
        map.put(hashCode, map.get(hashCode)+1);
    } else {
        map.put(hashCode, 1);
    }
}