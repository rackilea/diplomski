SharedPreferences settings = getSharedPreferences("isThreadRunning", 0);
   boolean running = settings.getBoolean("silentMode", false); //if it doesnt exist it will automatically set to false which means the thread hasnt or isnt running

 then just test.

 if(running){
 //Do something
 }else{
 //the thread isnt running so lets start it.
 }