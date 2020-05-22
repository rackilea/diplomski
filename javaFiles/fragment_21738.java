JSONObject json = (JSONObject) JSONSerializer.toJSON(data);        
    double coolness = json.getDouble( "coolness" );
    int altitude = json.getInt( "altitude" );
    JSONObject pilot = json.getJSONObject("pilot");
    String firstName = pilot.getString("firstName");
    String lastName = pilot.getString("lastName");

    System.out.println( "Coolness: " + coolness );
    System.out.println( "Altitude: " + altitude );
    System.out.println( "Pilot: " + lastName );