boolean firstTime = true;
    OnTouchListener testTouchListener = new OnTouchListener(){
        public boolean onTouch(View v, MotionEvent me){
            Rect r = new Rect();
            secondButton.getDrawingRect(r);
            if(r.contains((int)me.getX(),(int)me.getY())){
                //Log.i(myTag, "Moved to button 2");
                if(firstTime == true){
                    firstTime = false;
                    secondButton.performClick();
                }
            }
            if(me.getAction() == MotionEvent.ACTION_UP){
                //When we lift finger reset the firstTime flag
                firstTime = true;
            }
            return false;

        }
    };
    firstButton.setOnTouchListener(testTouchListener);