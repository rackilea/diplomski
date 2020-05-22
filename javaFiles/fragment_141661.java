@Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
          if(stopWatch.getTime > lastEventTime+delay){//pseudo code
            if (currentEvent==Event.SINGLE_TAP){
                mainMessage.setText("single tap");
                currentEvent=Event.DOUBLE_TAP;//set to next desired event
                return true;
            }
          }

            return false;
        }