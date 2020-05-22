java.util.TimerTask task = new java.util.TimerTask() {
        @Override
        public void run() {
            System.out.println("yoo");
        }
    };
    java.util.Timer timer = new java.util.Timer();
    timer.schedule(task, java.util.Calendar.getInstance().getTime(), 250);