Public Object traverseMap(Object key)
    while(hm.get(key) != null){
      key = hm.get(key);
    }
    return key;
 }