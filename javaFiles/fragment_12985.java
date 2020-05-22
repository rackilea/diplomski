Map<String,String> copy = new HashMap<>();

for(Entry<String, String> entry : headers.entrySet()){
    copy.put(entry.getKey() !=null ? entry.getKey().toLowerCase() : null, 
             entry.getValue() !=null ? entry.getValue().toLowerCase() : null
            );
}