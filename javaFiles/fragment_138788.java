Thread t = new Thread() {
    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                Thread.sleep(30);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run(){
                        if (isCollide) {
                            net.setVisibility(View.GONE);
                            ball.setVisibility(View.GONE);
                        } else {
                            Render();
                        }
                    }
                });

                if (isCollide) Thread.currentThread().interrupt(); // stop the thread
            }
        }catch (InterruptedException e) {}}};

t.start();