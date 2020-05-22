// this is a field
private Object waitOnThis = new Object();

new Thread(new Runnable() { public void run()
                            {
                                // thread code
                                waitOnThis.wait(); // blocks until notify / notifyAll is called on waitOnThis
                                // by this point ready.equals("yes")
                                if (ready.equals("yes")) {
                                    // handler code
                                }
                                // more thread code
                            }).start();

// later on...
ready = "yes";
waitOnThis.notifyAll(); // unblocks threads waiting on waitOnThis