for (int i = 0; i < jArray.length(); i++) {
            final JSONObject json = jArray.getJSONObject(i);

            if (listDataChild.get(json.getString("Category")) == null) {
               tempList = new ArrayList<String>();
               tempList.add(json.getString("Tag"));
               listDataChild.put(json.getString("Category"), tempList );
            }else{
               tempList = listDataChild.get(json.getString("Category"));
               tempList.add(json.getString("Tag"));
               listDataChild.put(json.getString("Category"), tempList );
           }