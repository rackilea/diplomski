new Thread(new Runnable(){

 public void run(){

    h.post(new Runnable(){


      // Do the UI work here.

   });

 }


});