List sortedList<String> = new ArrayList<String>();
Enumeration enumeration = properties.keys();  
while (enumeration.hasMoreElements()) {  
    String key = (String) enumeration.nextElement();
    sortedList.add(key);
}
Collection.sort(sortedList);

for(String key: sortedList){
    String nodeObj = key+" : "+properties.get(key);
    // [...] same as above
}