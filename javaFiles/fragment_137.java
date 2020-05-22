public void timeTick()
    {
     minutes.increment()
     if(minutes.getValue() == 0) {  // it just rolled over!
         hours.increment(); 
        }
     if (hours.getValue() == 0)
         {
         isAM = !isAM;   
        }   
    updateDisplay();
    }