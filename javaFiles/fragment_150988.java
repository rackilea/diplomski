for (final File x: store){   
       new Thread(new Runnable() {

         @Override
         public void run() {
           new de().commit(x);  // "de" should be "De" since it is a class
         }
       }).start();
    }