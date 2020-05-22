if(pressNumber < 3){
   pressNumber++; //increment the pressing to another value
   buttonIDs[pressNumber] = view.getId(); //use that value as index to button id
   if(runnable != null){
          handler.removeCallbacks(runnable); // if there was any handler still running cancel it first because we have clicked some button
   }
   startCounter(); //after click always start counter and remember if the counter finishes it will reset everything
} else{

 //Do something here the user has clicked all the buttons 4 times without delaying 1 second each!. The order of button clicks is the integer array buttonIDs and you can clearEverything(); to start again!

}