Map<String, String[]> articleData =  request.getParameterMap();
for(String key : articleData.keySet())
{
    BasicDBObject data =new BasicDBObject();
    for(int i=0; i<articleData.get(key).length;i++)
       {
         data.put("",articleData.get(key)[i]);

       }
     document.put(key,data);
 }
table.insert(document);