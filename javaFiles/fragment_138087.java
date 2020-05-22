JSONParser jParser = new JSONParser();
        JSONObject json = jParser.getJSONFromURL(url);

        //for loop useless

            try {

                //JSONObject c = json.getJSONObject(i); is useless. you are not getting i-th object of array because there is no loop and no array

                String ping = json.getString("ping");
                String pcurrent = json.getString("online"); //if returns true/false use getBoolean instead of getString?

                //max is inside of another object. get it first to get to it.
                JSONObject playersObject = json.getJSONObject("players");
                String pmax = playersObject.getString("max");

                HashMap<String, String> map = new HashMap<String, String>();

                map.put(PING, ping);
                map.put(PCURRENT, pcurrent);
                map.put(PMAX, pmax);
                jsonlist.add(map);

            } catch(JSONException e) {

                e.printStackTrace();

            }