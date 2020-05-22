String s = "{ \"15:00\":{\"type\":1,\"status\":null,\"appointment_id\":null},\"16:00\":{\"type\":1,\"status\":null,\"appointment_id\":null},\"17:00\":{\"type\":1,\"status\":null,\"appointment_id\":null},\"18:00\":{\"type\":1,\"status\":\"1\",\"appointment_id\":5}}";
    try {
        JSONObject jobj = new JSONObject(s);
        Iterator iter = jobj.keys();
        while(iter.hasNext()){   
            String appointmentTime = String.valueOf(iter.next());
            aRRaY.add(appointmentTime);

     }
      Collections.sort(aRRaY); 
      for(String key : aRRaY){
          JSONObject appointmentDetails = jobj.getJSONObject(key);
          System.out.println(key +" ----- "+appointmentDetails);
      }

    }
    catch (JSONException e) {
        e.printStackTrace();
    }