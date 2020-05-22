Arrays.sort(resultarray);

//if you require hash map only then
Map<Integer, String> source = new HashMap<Integer,String>();
for(int i=1;i<=resultarray.length;i++){
 source.put(i,resultarray[i]);
}