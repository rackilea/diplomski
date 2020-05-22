try {
            passengers.put(getPerson(1, 30));
            passengers.put(getPerson(2, 30));
            passengers.put(getPerson(3, 1));
        } catch (JSONException e){
            e.printStackTrace();
        }
        try {
            jsonBody.put("origin_id", 1);
            jsonBody.put("destination_id", 17);
            jsonBody.put("date", "2015-08-15");
            jsonBody.put("passengers", passengers);
        } catch (JSONException e){
            e.printStackTrace();
        }