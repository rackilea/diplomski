String s = "12314"; 
        Integer delay = Integer.parseInt(s);
        Timer timer = new Timer(); 
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                // TODO Auto-generated method stub

            }
        };
        timer.schedule(task, delay);