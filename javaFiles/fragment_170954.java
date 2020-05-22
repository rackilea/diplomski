im.post(new Runnable() {   
   int j = 0;      
   @Override   
   public void run() {
      im.setImageBitmap(bm[j]);
      if(j++ < 10){
         im.postDelayed(this, 1000);
      }
   }
});