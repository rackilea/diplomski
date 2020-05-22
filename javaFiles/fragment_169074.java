byte[] myPW = {33,33,33,33,33};
    byte[] myPWOriginalHashed = {0}; ;
    try {myPWOriginalHashed = SecurityHash.test(new byte[]{33,126,126,126,126});} 
    catch(Exception ex) {}
    int counter = 1;
    while (true) {
        for (int i = 33; i < 128; i++) {
            final int iFinal = i;
            for (int j = 33; j < 128; j++) {
                final int jFinal = j;
                for (int k = 33; k < 128; k++) {
                    final int kFinal = k;

                    Thread myThread = new Thread(new Runnable() {

                        @Override
                        public void run() {
                            for (int m = 33; m < 128; m++) {
                                for (int l = 33; l < 128; l++) {
                                            myPW = new byte[] { (byte) iFinal, (byte) jFinal, (byte) kFinal, (byte) l, (byte) m };
                                            byte[] myPWHashed = { 0 };
                                            try {
                                              myPWHashed = SecurityHash.test(myPW);
                                            } catch (Exception ex) {
                                                System.out.println(ex.getLocalizedMessage());
                                            }
                                            // See if we have a match
                                            if (Arrays.equals(myPWHashed, myPWOriginalHashed)) {
                                                // We have a match
                                                System.out.println(counter + " words processed");
                                                throw new Exception("Done");
                                            }
                                        }

                                    }
                        }
                  });

                  myThread.start();

                 }
              }
          }
        }