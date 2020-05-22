ArrayList<String> list = new ArrayList<String>();     
JSONArray jsonArray = (JSONArray)jsonObject; 
int len = jsonArray.length();
if (jsonArray != null) { 
   for (int i=0;i<len;i++){ 
    list.add(jsonArray.get(i).toString());
   } 
}
//Remove the element from arraylist
list.remove(position);
//Recreate JSON Array
JSONArray jsArray = new JSONArray(list);