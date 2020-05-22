JSONArray itemList = new JSONArray(c.getString("item_list"));
// loop through the array itemList and get the items
for(int i=0;i<itemList.length();i++) 
{ 
String item = itemList.getString(i); // item at index i
}