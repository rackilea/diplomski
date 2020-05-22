public void startPulsing() throws Exception {
    new Runnable() {
        @Override
        public void run() {
            pulse = true;
            win.setVisible(true);
            boolean decreasing = true;
            double inc = 0.05;
            double current = win.getOpacity();

            while(pulse) {
                if(doPulse) {
                    if(decreasing) {
                        current = current - inc;

                        if((float) current <= floor) {
                            current = floor;
                            win.setOpacity((float) current);
                            decreasing = false;
                        } else {
                            win.setOpacity((float) current);
                        }
                    } else {
                        current = current + inc;

                        if((float) current >= 1.0f) {
                            current = 1.0;
                            win.setOpacity((float) current);
                            decreasing = true;
                        } else {
                            win.setOpacity((float) current);
                        }
                    }
                } else {
                    current = 1.0;
                    win.setOpacity(1.0f);
                    decreasing = true;
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            win.setOpacity(1.0f);
        }
    }.run();
}