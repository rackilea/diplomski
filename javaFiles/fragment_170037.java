button.setOnClickListener(new OnClickListener {
        if(timerIsOn){
          if(timer != null){
            timer.cancel();
            timerIsOn = false;
          }
        }
        else{
        timerIsOn = true;
        //start the timer and do whatever else
        }
    }