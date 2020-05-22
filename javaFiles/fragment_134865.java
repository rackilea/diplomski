@Override 
public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
            float velocityY)
    {           
        if(GameWindow.getContext() == null)
            return false;

        if((e1.getY() >= GameWindow.getHeight()) && (e1.getY() <= GameWindow.getBottom()))
        {       

            try
            {                
                if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH) 
                    return false;               

                // right to left slap               
                if((e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE) && 
                        (Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY))
                {                                   
                    slappingLeft = true;

                    //Animate Slap  
                    SlapLeft();
                    SlapSound();
                    if(voice.nextInt(10) < 3)
                    {
                        Voice.start();
                    }

                }  
                // left to right slap
                else if ((e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE) && 
                        (Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY))               
                {       
                    slappingRight = true;

                    //Animate Slap
                    SlapImage();
                    SlapSound();
                    if(voice.nextInt(10) < 3)
                    {
                        Voice.start();
                    }
                }
            }                
            catch (Exception e)                 
            {                                   
                //nothing                                   
            }               
        }

        slappingLeft = slappingRight  = false;
        return true;            
    }