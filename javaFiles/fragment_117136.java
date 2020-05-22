JSONArray names = json.names();
    JSONArray values = json.toJSONArray(names);
    for(int i=0; i<values.length(); i++){
        if (names.getString(i).equals("description")){
            setDescription(values.getString(i));
        }
        else if (names.getString(i).equals("expiryDate")){
            String dateString = values.getString(i);
            setExpiryDate(stringToDateHelper(dateString)); 
        }
        else if (names.getString(i).equals("id")){
            setId(values.getLong(i));
        }
        else if (names.getString(i).equals("offerCode")){
            setOfferCode(values.getString(i));
        }
        else if (names.getString(i).equals("startDate")){
            String dateString = values.getString(i);
            setStartDate(stringToDateHelper(dateString));
        }
        else if (names.getString(i).equals("title")){
            setTitle(values.getString(i));
        }
    }