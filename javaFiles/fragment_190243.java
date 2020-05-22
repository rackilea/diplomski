try{
       jProgBar.setIndeterminate(true);
       jProgBar.setStringPainted(true);
       jProgBar.setBorderPainted(true);
       new Thread(new Runnable() {
           public void run() {
               ...
               // here is code that i've to wait
               // after this i stop my jProgressBar
               ...
               jProgBar.setStringPainted(false);
               jProgBar.setBorderPainted(true);
               jProgBar.setIndeterminate(false);
       }
       }).start();
   }
   catch(IllegalStateException ex){
       //some code
   }