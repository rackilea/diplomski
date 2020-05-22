Thread th = new Thread(new Runnable() {  ... } );
 th.start();
 //do work 
 //when need to wait for it to finish
 th.join();
 //th has now finished