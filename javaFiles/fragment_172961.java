r= new Random();
        m_handler= new Handler();
        m_handlerTask = new Runnable()
        {
             @Override 
             public void run() {
                 n=r.nextInt(4)+1;
                    if(n==1){
                        I1.setVisibility(View.VISIBLE);
                        I2.setVisibility(View.INVISIBLE);
                        I3.setVisibility(View.INVISIBLE);
                        I4.setVisibility(View.INVISIBLE);

                    }
                    if(n==2){
                        I2.setVisibility(View.VISIBLE);
                        I1.setVisibility(View.INVISIBLE);
                        I3.setVisibility(View.INVISIBLE);
                        I4.setVisibility(View.INVISIBLE); 
                    }

                    if(n==3){
                        I3.setVisibility(View.VISIBLE);
                        I1.setVisibility(View.INVISIBLE);
                        I2.setVisibility(View.INVISIBLE);
                        I4.setVisibility(View.INVISIBLE); 
                    }

                    if(n==4){
                        I4.setVisibility(View.VISIBLE);
                        I1.setVisibility(View.INVISIBLE);
                        I3.setVisibility(View.INVISIBLE);
                        I2.setVisibility(View.INVISIBLE); 
                    }
                  m_handler.postDelayed(m_handlerTask, 50);
                      // 50 milli seconds. set this to desired number
             }
        };
        m_handlerTask.run();