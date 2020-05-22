public static void getHttpUrlformachineList(String response, String CalId, String componentName)
            throws Exception
      {
           //System.out.println(response);
           Map<String, String> data = new HashMap<String, String>();
           JSONParser parser = new JSONParser();
           JSONObject object = (JSONObject) parser.parse(response);
           JSONObject getValue = (JSONObject) object.get(CalId.trim()); //CalId is the dynamic value that mentioned in the JSON input file
           JSONArray getCalSummary = (JSONArray) object.get("callSummary"); // callSummary is a JSONArray, not JSONObject
           for (int i = 0; i < getCalSummary.length(); i++) {
               JSONObject obj = getCalSummary.getJSONObject(i);
               if (obj.has("calls")) {
                   // grab calls array:
                   JSONArray callsArray = obj.getJSONArray("calls");
               }
           }
       }