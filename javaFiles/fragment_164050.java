new Thread((new Runnable() {

      @Override
      public void run() {
          try {
              while (true) {
                  ...
                  // reference null Activity. Throw NPE
                  ...
              }
          } catch (NullPointerException e) {
              Log.e(DEBUG, "Activity reference became null. Finishing thread.");
          }

      }   
}  ).start();