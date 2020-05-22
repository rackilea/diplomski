// adding each child node to HashMap key => value
            for (int i = 0; i < finalResult.length(); i++) {
                // creating new HashMap
                HashMap<String, String> map = new HashMap<String, String>();

                JSONObject c = finalResult.getJSONObject(i);

                if(c.has(TAG_CLIENT_NAME)&&!c.isNull(TAG_CLIENT_NAME)){
                    String clientName = c.getString(TAG_CLIENT_NAME);
                    map.put("client_name_map", clientName);
                    //System.out.println(clientName);
                }
                if(c.has(TAG_PROJECT_NAME)&&!c.isNull(TAG_PROJECT_NAME)){
                    String projectName = c.getString(TAG_PROJECT_NAME);
                    map.put("project_name_map", projectName);
                }

                // adding HashList to ArrayList
                ticketList.add(map);
                //System.out.println(map);
            }