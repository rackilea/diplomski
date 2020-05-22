static private void createHomeCallTimer() {
        new java.util.Timer().scheduleAtFixedRate(new java.util.TimerTask() {
            public void run() {
                // log.info("homeCall run");
                // Main main = new Main();
                String data = "xxxxx";
                System.out.println(data);

                // log.info("Start of HOMECALL with data: " + data);
                // new TCPClient().openSocketAndSendData(data);

            }
        }, 0, HOMECALLTIME);
    }