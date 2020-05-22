runOnUiThread(new Runnable() //run on ui thread
      {
           public void run() 
           { 
                 while(true){
                 n=randomGenerator.nextInt(8);

                 if(n==1){
                  I1.setVisibility(View.VISIBLE);
                 }
                 ....
                 }
           }
       });