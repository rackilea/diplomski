float timeState=0f; 

public void render(){
// ............
timeState+=Gdx.graphics.getDeltaTime();
if(timeState>=1f){
// 1 second just passed
   timeState=0f; // reset our timer
    updateEverySecond(); // call the function that you want
}