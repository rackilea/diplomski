DataOutputStream dos = 
Map<K, V> map = 
dow.writeInt(map.size());
for(Entry<K, V> entry: map.entrySet()) {
    dos.writeXxxx(entry.getKey());
    dos.writeXxxx(entry.getValue());
}