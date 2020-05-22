void addCard(String lineToParse){

    String[] tokens = lineToParse.split("##########");
    for(int i=0; i<tokens.length; i++) {
        playerList.add(tokens[i]);
    }
}