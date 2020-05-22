for(int i = 0; i < flips; i++){
                    try{
                        Thread.sleep(1000);
                    }catch(InterruptedException e2){
                        System.exit(1);
                    }
                    System.out.println("Auto Flipped");
                    changeFace();
                }