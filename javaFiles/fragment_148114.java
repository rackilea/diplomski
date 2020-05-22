public Object parseJsonForKey(String key,JSONObject jsonObject) throws DigitalSelfException{
          try {
            String[] keyPathArray = key.split("\\.");
            System.out.println("Array length :" + keyPathArray.length);
            if (keyPathArray.length == 1) {
                if (jsonObject.containsKey(key)) {
                    return jsonObject.get(key);
                } else {
                    return null;
                }
            }
            JSONObject tempObj = new JSONObject();
            JSONArray tempArray = new JSONArray();
            if (jsonObject.get(keyPathArray[0]) instanceof JSONObject) {
                tempObj = (JSONObject) jsonObject.get(keyPathArray[0]);
            } else if (jsonObject.get(keyPathArray[0]) instanceof JSONArray) {
                tempArray = (JSONArray) jsonObject.get(keyPathArray[0]);
                tempObj = (JSONObject) tempArray.get(0);
            }
            System.out.println(tempObj.toString());
            for (int i = 1; i < keyPathArray.length - 1; i++) {
                if (tempObj.containsKey(keyPathArray[i])) {
                    if (tempObj.get(keyPathArray[i]) instanceof JSONObject) {
                        tempObj = (JSONObject) tempObj.get(keyPathArray[i]);
                    } else if (tempObj.get(keyPathArray[i]) instanceof JSONArray) {
                        tempArray = (JSONArray) tempObj.get(keyPathArray[i]);
                        tempObj = (JSONObject) tempArray.get(0);
                    }                   
                    System.out.println(tempObj.toString());
                } else {
                    return null;
                }
            }
            if (tempObj.containsKey(keyPathArray[keyPathArray.length - 1])) {
               return tempObj.get(keyPathArray[keyPathArray.length - 1]);
            } else {
                return null;
            } 
        } catch (Exception e) {
            // throw Exception
        }