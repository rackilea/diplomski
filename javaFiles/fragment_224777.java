final Handler handler1 = new Handler(Looper.getMainLooper());
handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 3s = 3000ms
              imgB1.setBackgroundColor(Color.RED);
              //post another action to be executed in 3 sec
              handler1.postDelayed(new Runnable() {
                  @Override
                  public void run() {
                      // Do something after 3s = 3000ms
                      imgB1.setBackgroundColor(Color.YELLOW);
                  }
              }, 3000);
            }
        }, 3000);