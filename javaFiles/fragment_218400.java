boolean up = false;
 while (!up) {
     try {
         // Try to connect
         up = true;
     } catch (Exception e) {
         Thread.sleep(5000);
     }
 }