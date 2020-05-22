JSONArray myArray = (JSONArray) JSONSerializer.toJSON(stationData);
    //Slightly hard coded here.
    String[][] test = new String[myArray.getJSONArray(0).size()][myArray.getJSONArray(1).size()];

    for(int i = 0; i < myArray.size(); i++){
        for(int j = 0; j < myArray.getJSONArray(i).size(); j++){
            test[i][j] = (String) myArray.getJSONArray(i).get(j);

        }
    }