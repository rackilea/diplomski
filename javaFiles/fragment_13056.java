for(int i = 0; i < urlList.size(); i++) {
         Thread t = new Thread(new Runnable() { 
               public void run() { 
                  try {
                     //parsedocument( urlList.get(i))           
                   } catch (Exception e) {   //Catching exeptions
                       e.printStackTrace();
                   }
              }
          });
          t.start();

     }