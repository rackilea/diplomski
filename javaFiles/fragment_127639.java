mainThread = new Thread() {public void run() {

        while (true) {
            if (!paused) {
                //... GAME STUFF ...
            }
            else synchronized (this) {
                try {
                    paused = false;
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
};