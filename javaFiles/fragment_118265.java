String[] arr=response.split(",");
List<Map<String,String>> list = new ArrayList();
for(int i = 0; i<arr.length; i+2){
String contactNo = arr[i];
String result = arr[i+1];
Map<String,String> m = new HashMap();
m.put(contactNo,result);
list.add(m);
}