facade.comFactory = new Factory(new ComThread("COM Thread", 15000, new  
                  Thread.UncaughtExceptionHandler() { 
                        @Override 
                        public void uncaughtException(Thread t, Throwable e) { 
                            // do something intelligent 
                        } 
                    }));