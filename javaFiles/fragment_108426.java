boolean gameInProgress = true;
int currentTimerValue,previousTimerValue,pausedTimerValue;
void setup(){

}
void draw(){
  if(gameInProgress){
    currentTimerValue = millis()-pausedTimerValue;
    println("currentTimerValue: " + currentTimerValue + " previousTimerValue: " + previousTimerValue);  
    previousTimerValue=currentTimerValue;
  }else{
    pausedTimerValue = millis()-currentTimerValue;
  }
}
void mousePressed(){
  gameInProgress = !gameInProgress;
  println("paused: " + (gameInProgress ? "NO" : "YES"));
}