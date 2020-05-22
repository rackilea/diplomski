try 
 {
    Timer t=new Timer();
    t.schedule(timertask, d.getDate(), 1000);
 } 
catch (Exception e) 
 {
   e.printStackTrace();
 }