String string = "[444398, 1]";
    string = string.substring(1, string.length()-1); //Turns it into "444398, 1"
    String[] stringInArray = string.split(", "); // Then makes it ["444398", "1"]

    int[][] temp = new int[4][2];

    temp[0][0] = Integer.parseInt(stringInArray[0]);
    temp[0][1] = Integer.parseInt(stringInArray[1]);