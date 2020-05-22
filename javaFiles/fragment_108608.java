List<Detail> detailList = new ArrayList<>();
        JSONArray journeys = new JSONObject("");
        for(int i = 0 ; i < journeys.length() ; i++) { // Traverse journeys
            JSONObject journey = journeys.getJSONObject(i); // get journeys(i) -> journey
            if(journey.has("legs")) { // if journey has "legs" key
                JSONArray legs = journey.getJSONArray("legs"); // get the legs array from journey object
                for(int j = 0 ; j < legs.length() ; j++) { // Traverse legs
                    JSONObject leg = legs.getJSONObject(j); // get legs(j) -> leg
                    if(leg.has("instruction")) { // if leg has "instruction" key in it
                        JSONObject instruction = leg.getJSONObject("instruction"); // get instruction jsonObject
                        String journeyType = journey.getString("$type");
                        String legType = leg.getString("$type");
                        String instructionType = instruction.getString("$type");
                        String detailed = instruction.getString("detailed"); // get detailed string in instruction object
                        detailList.add(new Detail(journeyType, legType, instructionType, detailed));
                    }
                }
            }
        }
        for(Detail detail : detailList) {
            TextView textView = new TextView([yourContext]);
            textView.setText(detail.detail);
            yourContentViewGroup.addView(textView);
            // or you can use View.inflate(context, layoutRes, yourContentViewGroup) and design a layout to show other detail instance values
        }