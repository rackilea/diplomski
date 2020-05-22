void setRandomColor(){
   if(!hasRandomColor())
      return;

   imgColor.setBackgroundColor(getRandomColor());

   imgColor.postDelayed(new Runnable(){ 
     void run(){
        setRandomColor();
     }
   }, 1750); // update color again after 1.75 sec
}

... 

setRandomColor();