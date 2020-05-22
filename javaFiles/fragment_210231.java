private void writeSaveData()
{
    String saveString = String.format("%d=%d", wins, losses);
    FileHandle scores = Gdx.files.local("Score");
    scores.writeString(saveString, false);
}


private void loadScores()
{
    FileHandle scores = Gdx.files.local("Score");
    String loaddedString = scores.readString(winstring);
    String[] scores = loadedString.split("=");
    wins = Integer.parseInt(scores[0]);
    losses = Integer.parseInt(scores[1])    
}