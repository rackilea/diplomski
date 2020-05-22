Runnable[] methods = new Runnable[]{
   new Runnable(){  // Object wrapper for method a
       @Override
       public void run(){  // method a
          System.out.println("This is inside method a");
       }
   },
   new Runnable(){  // Object wrapper for waiting
       @Override
       public void run(){   // method to wait for 20s
          try{ Thread.sleep(20000); }catch(Exception e){}
       }
   },
   new Runnable(){  // Object wrapper for method b
       @Override
       public void run(){  // method b
          System.out.println("This is inside method b");
       }
   }
};