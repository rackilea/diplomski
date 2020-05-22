public void a(){               // just for testing
          try {
                Thread.sleep(1);          //OR some for loop to print something
             } catch (InterruptedException e) {

            e.printStackTrace();
             }
         }

           long startTime=System.currentTimeMillis();
            m.invoke(Bidlist[0], null);
            long endTime=System.currentTimeMillis();
            System.out.println("show takes "+(endTime-startTime)+" ms");