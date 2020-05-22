Runtime.getRuntime().addShutdownHook(new Thread() {
          public void run() {
              for (Statement s : list of running statements) {
                 s.cancel();
              }
          }
    });