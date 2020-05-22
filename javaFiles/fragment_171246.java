while(isRunning){

            beginTime = SystemClock.uptimeMillis(); 
            framesSkipped = 0;

            //Update game state
            update();

            render();

            //how long we took to update and render
            loopTime = SystemClock.uptimeMillis() - beginTime;
            //calculate how long to sleep
            sleepTime = loopPeriod - timeDiff; 

                //All work was done on time.
                if (sleepTime > 0) { 
                    try { 
                        Thread.sleep(sleepTime); 
                    } catch (InterruptedException e) {} 
                } 

                //We were too slow. Update without rendering.
                while (sleepTime < 0 && framesSkipped < MAX_FRAME_SKIPS) { 
                  update();
                    //make sure we don't keep looping here.
                    sleepTime += loopPeriod; 
                    framesSkipped++; 
                }
            }
        }