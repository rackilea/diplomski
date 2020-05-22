JSONArray journeys = new JSONObject("");
        for(int i = 0 ; i < journeys.length() ; i++) { // Traverse journeys
            JSONObject journey = journeys.getJSONObject(i); // get journeys(i) -> journey
            if(journey.has("legs")) { // if journey has "legs" key
                JSONArray legs = journey.getJSONArray("legs"); // get the legs array from journey object
                for(int j = 0 ; j < legs.length() ; j++) { // Traverse legs
                    JSONObject leg = legs.getJSONObject(j); // get legs(j) -> leg
                    if(leg.has("instruction")) { // if leg has "instruction" key in it 
                        JSONObject instruction = leg.getJSONObject("instruction"); // get instruction jsonObject
                        String detailed = instruction.optString("detailed", "Fallback detailed"); // get detailed string in instruction object
                    }
                }
            }
        }