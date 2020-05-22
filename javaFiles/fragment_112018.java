@Override
    public boolean dispatchTouchEvent(MotionEvent motionEvent){
          Log.v("NotificationActivity.dispatchTouchEvent()", "got touch");

          if (motionEvent.getPointerCount() == 2) {
    Log.v("touch", "multi touch !");
              int action = motionEvent.getAction();
              int pureaction = action & MotionEvent.ACTION_MASK;
              // some actions ...
          }

        switch (motionEvent.getAction()){
            case MotionEvent.ACTION_DOWN:{
                //Keep track of the starting down-event.
                Log.v("akcjaa","down");
     // some actions ...
                break;
            }
            case MotionEvent.ACTION_UP:{
                //Consume if necessary and perform the fling / swipe action
                //if it has been determined to be a fling / swipe
              Log.v("akcjaa","up");
                break;
            }

        }
        return super.dispatchTouchEvent(motionEvent);
    }