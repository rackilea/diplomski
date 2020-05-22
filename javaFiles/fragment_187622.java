double result;
    Thread t = new Thread(){
      public void run(){
        result = isColliding(aParticle, aParticle);
      }
    };
    t.start();

    t.join();