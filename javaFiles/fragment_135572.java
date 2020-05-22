for (int i=0;i<10;i++) 
     new Thread(new Runnable(){
         public void run(){
             System.out.println(df.format(date));
         } 
     });