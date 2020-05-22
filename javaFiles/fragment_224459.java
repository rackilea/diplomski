String keyOneValue="";
for(Map.Entry<String,List<String>> entry : map.entrySet()){
    if(entry.getValue().size()==1){
        keyOneValue = entry.getKey();
        break;
    }
}
System.out.println(keyOneValue);  // c