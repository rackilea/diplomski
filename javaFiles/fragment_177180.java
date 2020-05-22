JSONArray arr = new JSONArray(JSONResp);

                for (int i = 0; i < arr.length(); i++) {

                    result.add(convertItem(arr.getJSONObject(i)));

                }