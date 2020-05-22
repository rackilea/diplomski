try {

                String j2 = obj.getString("values");
                JSONArray jContent = new JSONArray(j2);
                                    for (int iterate = 0; iterate < jContent.length(); iterate++) {
                        JSONObject inner = jContent.getJSONObject(iterate);
                        String inner_label = (String) inner.get("label");

                        System.out.println(inner_label);

                        String val = (String) inner.get("value");
                        boolean sel;
                        try {
                            sel = (boolean) inner.get("selected");

                        } catch (JSONException j) {
                            sel = false;
                        }
                        System.out.print(inner_label);
                        System.out.print(" " + val);
                        System.out.println(" " + sel);

                    }