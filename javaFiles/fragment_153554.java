Map<String, Hello> map=new HashMap<>();
Set<Entry<String, Hello>> entries=map.entrySet();
for (Entry<String, Hello> entry : entries) {
    String key=entry.getKey();
    Hello hello=entry.getValue();
}