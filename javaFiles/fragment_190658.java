public void run() {
      double v = 5;
      double c = Math.PI*2;
      double a = .1;
      double b = .0053468;

      setMaxVelocity(v);
      setAhead(100*999);
      setTurnRight(360*999);
      while(true)
      {
          double t = getTime();
          double f = a*Math.pow(Math.E,b*t);
          double w = v/(c*f);       

          setMaxTurnRate(w);
          execute();
          System.out.println(t+"\t"+w);
      }
    }