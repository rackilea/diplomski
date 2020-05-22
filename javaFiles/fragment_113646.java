JSONArray list = new JSONArray();     
JSONArray jsonArray = new JSONArray(jsonstring); 
int len = jsonArray.length();
if (jsonArray != null) { 
   for (int i=0;i<len;i++)
   { 
       //Excluding the item at position
        if (i != position) 
        {
            list.put(jsonArray.get(i));
        }
   } 
}