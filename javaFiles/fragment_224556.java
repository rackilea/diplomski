private final ConcurrentHashMap<String, Object> hashMap =
    new ConcurrentHashMap<String, Object> ();

void setByteArray(String string, byte[] byteArray) {
    hashMap.put(string, byteArray.clone());
}

byte[] getByteArray(String string) {
    Object result = hashMap.get(string);
    if(result == null)
        return null;
    else
        return ((byte[]) result).clone();
}