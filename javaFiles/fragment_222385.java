Iterator keys = jsonObject1.keys();
while(keys.hasNext()) {
            // loop to get the dynamic key
            String currentDynamicKey = (String)keys.next();
            JSONObject json = jsonObject1.getJSONObject(currentDynamicKey);

        }