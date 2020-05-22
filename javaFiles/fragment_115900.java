new Thread(new Runnable() {

                           @Override
                           public void run() {
                                   while(!Thread.interrupted())
                                   {

                                       Message msg=new Message();
                                       msg.obj="your text";
                                       mHandler.sendMessage(msg);
                                        try {
                                            Thread.sleep(100);
                                        } 
                                        catch (InterruptedException e) {
                                           e.printStackTrace();
                                        }
                                   }
                           }
                   }).start();