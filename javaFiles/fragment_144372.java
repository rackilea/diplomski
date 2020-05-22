new Thread(new Runnable(){
    public void run(){

    //example code
    while(flag==true){
     System.out.println("Yeah i am true "); 
     //Thread.sleep(200); //Makes The Thread sleep
    }

  }}).start();   //create and start by default