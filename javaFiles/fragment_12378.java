new Thread(new Runnable() { public void run()
                            {
                                // thread code
                                if (ready.equals("yes")) {
                                    // handler code
                                }
                                // more thread code
                            }).start();

// later on...
ready = "yes";