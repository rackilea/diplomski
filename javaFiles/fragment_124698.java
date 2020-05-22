Future<?> future =  exec.submit(new Runnable(){
                                public void run() {
                                       if (bar()) {
                                              foo();
                                       }
                                }
                                });

//blocks
future.get();