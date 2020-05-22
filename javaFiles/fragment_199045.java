while (true) {
     for (i=0; i < alg.length; i++) 
        if (execPanel[i].isReset()) {
           alg[i].terminate();
           createProgram(i);
           alg[i].start();
           execPanel[i].unreset();
        }         
  }