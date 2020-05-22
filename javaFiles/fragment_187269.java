// get the raw data on score and time
int totalScore = 0;
int totalMinutesPlayed = 0;
for(int i = 0; i < games.length; i++)
{
    totalScore += games[i].getScore();
    totalMinutesPlayed += games[i].getMinutesPlayed;
}

// compile the output string
String output = "Games Played: " + gamesPlayed
 + "\n\nTotal Achievement: " + totalScore
 + "\n\nTotal Time: " + totalMinutesPlayed
 + " (" + totalMinutesPlayed / 60
 + " hours and " + totalMinutesPlayed % 60
 + " minutes).";

// write the string to the file
writer.println(output);