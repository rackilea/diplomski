// time between each move
final int SLEEP_TIME = 1000;

//each animal has this variable, it is the last time they moved
long lastMoveTime;

public boolean shouldMoveRabbit(){
    if(System.currentTimeMillis() >= lastMoveTime + SLEEP_TIME)
         return true;
    return false;
}
public void doMoveRabbit(){
    lastMoveTime = System.currentTimeMillis();
    // move stuff
}