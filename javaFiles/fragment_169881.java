BufferedReader readInputProc=new BufferedReader(new InputStreamReader(extProc.getInputStream()));
      while(readInputProc.ready()) {
        theReadBuffer = readInputProc.readLine();
        System.out.println(theReadBuffer);
      }
      BufferedReader readErrorProc=new BufferedReader(new InputStreamReader(extProc.getErrorStream()));
      while(readErrorProc.ready()) {
        theReadBuffer = readErrorProc.readLine();
        System.out.println(theReadBuffer);
      }