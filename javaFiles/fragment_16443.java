try
            {
                    //This is the whole thing
                    JSONObject Jresult = new JSONObject(result);
                    //Now we take the JSONarray results
                    JSONArray Results = Jresult.getJSONArray("results");
                    //IMPORTANT
                    //Now we have to take the object in the array.  
                  //Since there is only 1 obj. You dont need a for loop
                    JSONObject ResObj = Results.getJSONObject(1);
                //Now we get the array address_components
                    JSONArray addressComps = ResObj.getJSONArray("address_components");
                  //Time to get the obj we want from the array
                    //Since u mentioned only thst one name and provided the result
                    //I knew the number in the array. In this case 3.
                    JSONObject needed = addressComps.getJSONObject(3);
                    //Now we get the required string
                    String longName = needed.getString("long_name");
            }
            catch (JSONException e)
            {}