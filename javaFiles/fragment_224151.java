if(event.getAction() == MotionEvent.ACTION_UP){
           // up is called
           touch++;
           Log.i("info", "touch # " + touch);
           return true;
       }