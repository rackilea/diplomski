public void contextInitialized(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("inside listener context");
        Timer timer = new Timer();
        Date executionDate = new Date();
        long period = 24 * 60 * 60 * 1000;
        timer.scheduleAtFixedRate(new MyTimerTask(), executionDate, period);    
  }