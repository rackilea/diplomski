public String[][] getGameMembers() {
    // Define our array
    String[][] playerTable = new String[2][6];

    if(!isIngame()) {
        return playerTable; // It's better practice to return an empty array rather than null. If an empty array is not allowed then throw an exception.
    }

    int TEAM_BLUE = 0; // Just an easy reminder in order to have more readable code
    int TEAM_RED = 1;

    int teamBlueCounter = 0; // Keep track of the next free element in team blue
    int teamRedCounter = 0; // idem

    //Get all Players
    List<Participant> participants = game.getParticipants();

    //Put each player in the Arraylist
    for(int i = 0; i < participants.size(); i++) {
        Participant participant = participants.get(i);

        String participantName = participant.getSummonerName() + " (" + participant.getChampion() + ")";

        //Get teams and put in the right place in array
        if( participant.getTeam() == Side.BLUE ) {
            playerTable[TEAM_BLUE][teamBlueCounter] = participantName;
            teamBlueCounter++;
        } else {
            playerTable[TEAM_RED][teamRedCounter] = participantName;
            teamRedCounter++;
        }
    }

    return playerTable;
}