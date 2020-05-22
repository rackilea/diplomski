public String[] getID(){
    // Create an array of String of length staffNum
    String[] tempArray = new String[staffNum];
    for(int x = 0; x < staffNum; x++){
        // Affect the value Att[x] to each element of my array
        tempArray[x] = String.format("Att[%d]", x);
    }
    return tempArray;
}