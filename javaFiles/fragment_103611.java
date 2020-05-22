class MyThread extends Thread {
    public void run(MyGraphic mg) {
        while(true) {
            try {
                mg.m = mg.m + 1;
                System.out.println(mg.m);
                sleep(1000);
            } catch(InterruptedException e) {
                System.out.println("Error is occured: " + e.getMessage());
            } 

        }
    }
}