tOut = new Timer();
tOut.schedule(new TimerTask() {
    @Override
    public void run() {
        long dif = System.currentTimeMillis() - lastCCReceivedTime;
        if (dif > 1000 * 10) {
            // socket is disconnected
            return;
        }


        try {
            out.println("Connection check");
        } catch (Exception e) {
            if (out != null)
                out.close();

            // socket is disconnected
        }
    }
}, 1000, 1000);