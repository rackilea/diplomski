JSONArray ja = new JSONArray();

while (products.readRecord())
{
    String productID = products.get("user");
    int j = Integer.parseInt(productID, 10);

    if(j == userId)
    {
         JSONObject jo = new JSONObject();
         itemid = products.get("item");
         jo.put("item", itemid);
         ja.add(jo);
    }

}  

out.println(ja);
products.close();