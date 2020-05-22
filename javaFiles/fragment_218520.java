String keys = "";
for(Map.Entry<String, Integer> m:  map.entrySet()){
 if(m.getValue()>toStringArray.length-1)
    keys = keys + " " + m.getKey();
}
System.out.print(keys.trim().split("\\s+").length);