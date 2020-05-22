//Specify a maximum time and record it in a variable; in this case, I'm using milliseconds as unit, and 30 seconds of time.
long maxQuestionTime = 30000;

//Outside the game-loop, at start of a question, record a timestamp of the current time + max time.
long maxQuestionTimestamp = System.currentTimeMillis()+maxQuestionTime;

//Inside game-loop, check if current time has gone above the timestamp, effectively measuring elapsed time.
if(System.currentTimeMillis()>maxQuestionTimestamp){
    //fail the question here
}