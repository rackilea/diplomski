JSONObject timeTable = new JSONObject(); // first create the "main" JSON Object
timeTable.put("route", 1);               // this first entry is just a number
JSONObject info = new JSONObject();      // now you need a second JSON OBject to put all the info in
info.put("direction", "Surrey Quays");   // first info, the direction

JSONObject stops = new JSONObject();     // now you need another Object for all the stops and stop related info
stops.put("stops_name", "Tension Way");  // like the name for the stop

JSONObject arrivals = new JSONObject();  // now all the arrivals
JSONArray arrivalMoFr = new JSONArray(); // this is the first time where an array makes sense here
arrivalMoFr.put("05:38");                // arrival time 1
arrivalMoFr.put("06:07");                // arrival time 2
arrivalMoFr.put("06:37");                //  ...
arrivals.put("mon-fri",arrivalMoFr);     // add the arrival times array as mon-fri to the arraivals object, do the same with all other arrival times (Saturday, Sunday...)
stops.put("arrival_time", arrivals);     // now add the arrival time object to your stops
info.put("stops", stops);                // and put the stops to your info
timeTable.put("info", info);             // once you added all your infos you can put the info into your timeTable

System.out.println(timeTable.toString(3));  // this is just for testing. The number 3 tells you how many whitespaces you want for text-identaion