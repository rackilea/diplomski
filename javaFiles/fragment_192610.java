HashMap<String,String[]> map = new HashMap<>();
        //write code for taking input from file into string arrays
        for(int i = 0; i < numOfRows; i++){
            for(int j = 0; j < 4; j++){
                map.put(weather[i], condition[i][j]);
            }
        }