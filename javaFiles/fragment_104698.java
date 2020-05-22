while((fileLine = bufferedReader.readLine()) != null){
    String[] splitResults = fileLine.split(":");
    if (splitResults.length > 1) {
        Score newScore = new Score();
        newScore.playerName = splitResults[0];
        newScore.playerScore = Integer.parseInt(splitResults[1]);
        scores.add(newScore);
    }
}