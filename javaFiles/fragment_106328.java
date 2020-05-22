try {
            JSONObject mainObject = new JSONObject();
            mainObject.put("source", "REMOTE");
            mainObject.put("msgType", "event");
            JSONArray mainArray = new JSONArray();

            JSONObject arrayObj = new JSONObject();
            JSONObject temp = new JSONObject();
            temp.put("string", "1234567890");
            arrayObj.put("IMEI", temp);
            mainArray.put(arrayObj);

            arrayObj = new JSONObject();
            temp = new JSONObject();
            temp.put("string", "5/4/2016 12:00:00");
            arrayObj.put("My Time", temp);
            mainArray.put(arrayObj);

            arrayObj = new JSONObject();
            temp = new JSONObject();
            JSONObject temp1 = new JSONObject();
            temp1.put("latitude",34.89767579999999);
            temp1.put("longitude",-72.03648269999997);
            temp.put("geographicPosition", temp1);
            arrayObj.put("Position", temp);
            mainArray.put(arrayObj);

            mainObject.put("properties", mainArray);
            // mainOject is your required Json 
            System.out.println(mainObject);
        } catch (Exception e) {
            e.printStackTrace();
        }