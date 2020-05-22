public static void main(String[] args) {
        int minutes = Integer.parseInt(args[0]);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
              @Override
              public void run() {
                  System.out.println("timer job...");             }
            }, 1*minutes*1000, 1*minutes*1000);
    }