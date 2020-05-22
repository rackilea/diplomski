Thread t1 = new Thread(new Runnable() {

        public void run() {            
            try {
                producer(); //This is called in run method!
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    });