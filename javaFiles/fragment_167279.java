final Handler handler = new Handler();

button.setOnClickListener(new OnClickListener() {
   public void onClick(View v) {
      firstImage.setVisibility(ImageView.VISIBLE);
      handler.postDelayed(new Runnable(){
            public void run(){
                 firstImage.setVisibility(ImageView.INVISIBLE);
            }
      }, DELAY);
   }
}