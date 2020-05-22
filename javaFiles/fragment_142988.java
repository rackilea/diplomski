@Override public void run() 
      { 
          for (int i = 0; i <= 1; i++)
          { 
              System.out.println("in queue"+i);
          }

          synchronized( Signal2NoiseRatio.this ) 
          { 
              Signal2NoiseRatio.this.notify(); 
          }
        }