Map<String, List<String>> map = new HashMap<>();
for(String s: ls){
  String[] k = s.split("/");
  if(k.length<2)
     throw new RuntimeException("Invalid input");
  if(map.get(k[0]==null)
     map.put(k[0], new ArrayList<String>());
  map.get(k[0]).add(Arrays.asList(Arrays.copy(k,1,k.length));
}