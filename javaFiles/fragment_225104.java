Timer timer = new Timer();
  long interval = (10*60*1000) ; // 10 minutes

  timer.schedule( new TimerTask() {
       public void run() {
          ReceiveMailPOP3.doit();
       }
  }, 0, interval);