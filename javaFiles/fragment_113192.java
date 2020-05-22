new Thread(new Runnable(){
    @Override
    public void run() {
        int x;
        for(x=0;x<=600;x++)
        {           
            try{
                Thread.sleep(50); 
            }
            catch(InterruptedException e)
            {
                System.err.println("sleep exception");
            }
            mv.setBounds(x,220,53,35);
        }
    }
}).start();