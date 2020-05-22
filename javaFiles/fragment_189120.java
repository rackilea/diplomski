public String get(String key) {
    //System.out.println(key+" "+ key.hashCode());
    int index = key.hashCode() % nButckets;
    System.out.println(index+"bfb"+hasKey(index, key));
    //hasKey(index, key) would return -1, because key[1423] is 6357, and not 1000 as you expected.
    if (hasKey(index, key) == 1) return valueArray[index]; 
     return null;
}

private int hasKey(int index, String key) {
    //System.out.println(keyArray[index]);
    if (keyArray[index] == null) {
        return 0;
    } else if (keyArray[index].equals(key)) {
        return 1;
    } else {
        return -1;
    }
}