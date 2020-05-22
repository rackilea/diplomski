public class Train {
Route route;
int capacity;
int recentLoc;
boolean forwards;
boolean atStation;
int speed;
Train currentTrain;
int timeAtStation;

//train constructor
public Train(Route r, int c, int i, boolean f, int s){
    route = r;
    capacity = c;
    recentLoc = i;
    forwards = f;
    speed = s;
    atStation = true;
    timeAtStation = 0;
}