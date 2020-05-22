JSONObject jsonObject;

                     String addre = null;
                     Address addr1 = null;
                    try {
                        jsonObject = serverCall.getName(Double.parseDouble(latitude.getText().toString()), 
                                Double.parseDouble(longitude.getText().toString()));



                        addre = ((JSONArray)jsonObject.get("results")).getJSONObject(0).getString("formatted_address");

                        if("OK".equalsIgnoreCase(jsonObject.getString("status"))){
                            Log.d("status",jsonObject.getString("status"));
                            addr1 = new Address(Locale.getDefault());
                            for(int i=1;i<((JSONArray)jsonObject.get("results")).length()-2;i++){

                            JSONArray addrComp = ((JSONArray)jsonObject.get("results")).getJSONObject(i).getJSONArray("address_components");
                            //Toast.makeText(getApplicationContext(),addrComp.toString(),Toast.LENGTH_LONG).show();
                           // Log.d("Geocoder",addrComp.toString());            
                            for(int j=0;j<addrComp.length();j++){


                            String neighborhood = ((JSONArray)((JSONObject)addrComp.get(j)).get("types")).getString(0);
                                if (neighborhood.compareTo("neighborhood") == 0) {
                                    String neighborhood1 = ((JSONObject)addrComp.get(j)).getString("long_name");
                                        addr1.setSubThoroughfare(neighborhood1);
                             } 
                            String locality = ((JSONArray)((JSONObject)addrComp.get(j)).get("types")).getString(0);
                            if (locality.compareTo("locality") == 0) {
                                String locality1 = ((JSONObject)addrComp.get(0)).getString("long_name");
                                    addr1.setLocality(locality1);
                            }

                            String subadminArea = ((JSONArray)((JSONObject)addrComp.get(j)).get("types")).getString(0);
                            if (locality.compareTo("administrative_area_level_2") == 0) {
                                String subadminArea1 = ((JSONObject)addrComp.get(j)).getString("long_name");
                                    addr1.setSubAdminArea(subadminArea1);
                            }
                            String adminArea = ((JSONArray)((JSONObject)addrComp.get(j)).get("types")).getString(0);
                            if (adminArea.compareTo("administrative_area_level_1") == 0) {
                                String adminArea1 = ((JSONObject)addrComp.get(j)).getString("long_name");
                                    addr1.setAdminArea(adminArea1);
                            }

                            String postalcode = ((JSONArray)((JSONObject)addrComp.get(j)).get("types")).getString(0);
                            if (postalcode.compareTo("postal_code") == 0) {
                                String postalcode1 = ((JSONObject)addrComp.get(j)).getString("long_name");
                                    addr1.setPostalCode(postalcode1);
                            }
                            String sublocality = ((JSONArray)((JSONObject)addrComp.get(j)).get("types")).getString(0);
                            if (sublocality.compareTo("sublocality") == 0) {
                                String sublocality1 = ((JSONObject)addrComp.get(j)).getString("long_name");
                                    addr1.setSubLocality(sublocality1); 
                            }
                            String countr = ((JSONArray)((JSONObject)addrComp.get(j)).get("types")).getString(0);
                            if (countr.compareTo("country") == 0) {
                                String countr1 = ((JSONObject)addrComp.get(j)).getString("long_name");

                                addr1.setCountryName(countr1);
                            }

                            }
                            }
                            addr_label.setText("Address:"+addre/*+","+addr1.getSubLocality()+","+addr1.getSubThoroughfare()+","+addr1.getLocality()*/);
                            city.setText("City:"+addr1.getSubAdminArea());
                            state.setText("State:"+addr1.getAdminArea());
                            country.setText("Country:"+addr1.getCountryName());
                            pin.setText("Pin:"+addr1.getPostalCode());
                        }else{
                            Toast.makeText(getApplicationContext(),
                                     "You may check your internet connection or latitude and longitude values",Toast.LENGTH_LONG).show();
                        }
                    } catch (JSONException e) {

                        Toast.makeText(getApplicationContext(),
                                 e.toString(),Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                        Log.d("JSONException",e.toString());
                    }