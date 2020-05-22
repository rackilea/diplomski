public void run() {
    y_pos = getHeight() / 2;
        while (true) {
            x_pos++;
            repaint();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (x_pos > getWidth()) { 
                x_pos = 10;
            }
        }
    }