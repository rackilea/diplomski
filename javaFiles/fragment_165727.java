public static <K,V> Map<K,V> mapFromArrays(K[] keys,V[]values){
    HashMap<K, V> result=new HashMap<K, V>();
    for(int i=0;i<keys.length;i++){
        result.put(keys[i], values[i]);
    }
    return result;

}