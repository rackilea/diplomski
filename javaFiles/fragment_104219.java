public Led() {
    this.setPreferredSize(new Dimension(50, 50));
    thread.start();
}

Thread  thread  = new Thread(() -> {
                    while (true) {
                        if (getBackground().equals(notOkColor)) {
                            setBackground(okColor);
                        } else {
                            setBackground(notOkColor);
                        }
                        try {
                            Thread.sleep(BLINK_FREQUENCY);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });