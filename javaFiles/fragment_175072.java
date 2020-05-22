/*CODE SECTION 1*/    
    JSONObject con =  new JSONObject();
                JSONArray contacts = new JSONArray();

/*CODE SECTION 2*/
    JSONObject contactInfo = new JSONObject();
                                        contactInfo.put("displayName" , name);
                                        JSONArray phoneNos = new JSONArray();
                                        JSONObject value = new JSONObject();
                                        value.put("value" , phoneNo);
                                        phoneNos.put(value);
                                        contactInfo.put("phoneNumbers" , phoneNos);
                                        contacts.put(contactInfo);

/*CODE SECTION 3*/
    con.put("contacts", contacts);