if (isPlaying == true) {
                    if (key == KeyEvent.VK_LEFT) {
                        dog.setSpeed(-dogSpeed);
                    }
                    if (key == KeyEvent.VK_RIGHT) {
                        dog.setSpeed(dogSpeed);
                    }
                    //xBallSpeed = ball.getXballSpeed();
                    //yBallSpeed = ball.getYballSpeed();
                }

                if (key == KeyEvent.VK_SPACE ){
                    isPlaying = !isPlaying;
                }

                if (key == KeyEvent.VK_SPACE && !isPlaying) {
                    timer.stop();
                    //ball.setXspeed(0);
                    //ball.setYspeed(0);
                }
                else if (key == KeyEvent.VK_SPACE && isPlaying ){   
                    //ball.setXspeed(xBallSpeed);
                    //ball.setYspeed(yBallSpeed);
                    timer.start();
                }