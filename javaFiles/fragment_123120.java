@Override
    protected void onResume() {
        super.onResume();

        t.scheduleAtFixedRate(new TimerTask() {
                                  @Override
                                  public void run() {
                                      // code here
                                  }
                              },
                //Set how long before to start calling the TimerTask (in milliseconds)
                20000,
                //Set the amount of time between each execution (in milliseconds)
                40000);
    }