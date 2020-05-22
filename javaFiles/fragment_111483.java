JSONArray myListsAll= new JSONArray(jsonStr);
for(int i=0;i<myListsAll.length();i++)
{
    JSONObject obj= (JSONObject) myListsAll.get(i);
    History= obj.getString("History");
    ...
}