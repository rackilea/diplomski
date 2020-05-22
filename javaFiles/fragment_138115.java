class Task extends TimerTask {

    int i=0;
    @Override
    public void run() {
        i++;
        if(i==1)
            System.out.println("Hello User");
        if(i==10){
            System.out.println("Ten Seconds Have Gone By");
        }
        if(i==13){
            System.out.println("Goodbye User");
            cancel();        
        }

    }
}