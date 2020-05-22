JSONArray parameterlist = new JSONArray();
parameterlist.add(map);
parameterlist.add(jsonObject);

jsonObject.put("parameters", parameterlist);
jsonObject.put("function", "create_contact_group");