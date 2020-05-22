Thread t1 = ..
   Thread t2 = ..

   t1.start();
   t1.join();
   t2.start(); // t2 will start only when t1 dies
   t2.join(); //  
   t3.start(); // t3 will start only when t2 dies..