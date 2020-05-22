public Thread calculation1(){
      Thread thread = new Thread(){
        public void run(){
          /* do calculation */
        }
      };
      thread.start();
      return thread;
    }

    public Thread calculation2(){
      Thread thread = new Thread(){
        public void run(){
          /* do some other calculation */
        };
      };

      thread.start();
      return thread;
    }