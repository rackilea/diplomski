public boolean active;
public void doWork(){
    active = true;
    new Thread(new Runnable() {         
        @Override
        public void run() {
            while(active){
                System.out.println("Working");
            }
        }
    }).start();
}
public void stopWork(){
    active = false;
}