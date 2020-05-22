private Handler repeatUpdateHandler = new Handler();
public int mValue;           //increment 
private boolean mAutoIncrement = false;          //for fast foward in real time
private boolean mAutoDecrement = false;         // for rewind in real time



private class RptUpdater implements Runnable {
        public void run() {
            if( mAutoIncrement ){
                mValue += 30; //change this value to control how much to forward
                mediaPlayer.seekTo(getCurrentPosition()+ mValue);
                repeatUpdateHandler.postDelayed( new RptUpdater(), 50 );
            } else if( mAutoDecrement ){
                mValue -= 30; //change this value to control how much to rewind
                seekTo(getCurrentPosition()- mValue);
                repeatUpdateHandler.postDelayed( new RptUpdater(), 50 );
            }
        }
    }



btnPrev.setOnTouchListener(new View.OnTouchListener() { 
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    v.setPressed(true);
                    mAutoDecrement = true;
                    repeatUpdateHandler.post( new RptUpdater() );
                    return false;
                }
                else if(event.getAction() == MotionEvent.ACTION_UP) {
                    v.setPressed(false);
                    if( (event.getAction()==MotionEvent.ACTION_UP || event.getAction()==MotionEvent.ACTION_CANCEL)
                            && mAutoDecrement ){
                        mAutoDecrement = false;
                    }
                    return false;
                }
                return false;
            }
        });

btnNext.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    v.setPressed(true);
                    mAutoIncrement = true;
                    repeatUpdateHandler.post( new RptUpdater() );
                    return false;
                }
                else if(event.getAction() == MotionEvent.ACTION_UP) {
                    v.setPressed(false);
                    if( (event.getAction()==MotionEvent.ACTION_UP || event.getAction()==MotionEvent.ACTION_CANCEL)
                            && mAutoIncrement ){
                        mAutoIncrement = false;
                    }
                    return false;
                }

                return false;
            }
        });