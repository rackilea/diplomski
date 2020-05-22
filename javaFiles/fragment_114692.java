{
   "destination_addresses" : [
      "Private"
   ],
   "origin_addresses" : [ "Private" ],
   "rows" : [
      {
         "elements" : [
            {
               "distance" : {
                  "text" : "1,052 km",
                  "value" : 1051911
               },
               "duration" : {
                  "text" : "17 hours 10 mins",
                  "value" : 61785
               },
               "status" : "OK"
            }
         ]
      }
   ],
   "status" : "OK"
}



 JSONParser parser = new JSONParser();
        try {

         Object obj = parser.parse(response);
         JSONObject jsonobj=(JSONObject)obj;

         JSONArray dist=(JSONArray)jsonobj.get("rows");
         JSONObject obj2 = (JSONObject)dist.get(0);
         JSONArray disting=(JSONArray)obj2.get("elements");
         JSONObject obj3 = (JSONObject)disting.get(0);
         JSONObject obj4=(JSONObject)obj3.get("distance");
         JSONObject obj5=(JSONObject)obj3.get("duration");
         System.out.println(obj4.get("text"));
         System.out.println(obj5.get("text"));

    }
catch(Exception e) {
    e.printStackTrace();
}