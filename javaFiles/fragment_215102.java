JSONObject json      = new JSONObject();
JSONArray  addresses = new JSONArray();
JSONObject address;
try
{
   int count = 15;

   for (int i=0 ; i<count ; i++)
   {
       address = new JSONObject();
       address.put("CustomerName"     , "Decepticons" + i);
       address.put("AccountId"        , "1999" + i);
       address.put("SiteId"           , "1888" + i);
       address.put("Number"            , "7" + i);
       address.put("Building"          , "StarScream Skyscraper" + i);
       address.put("Street"            , "Devestator Avenue" + i);
       address.put("City"              , "Megatron City" + i);
       address.put("ZipCode"          , "ZZ00 XX1" + i);
       address.put("Country"           , "CyberTron" + i);
       addresses.add(address);
   }
   json.put("Addresses", addresses);
}
catch (JSONException jse)
{ 

}
response.setContentType("application/json");
response.getWriter().write(json.toString());