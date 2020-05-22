final Handler handler = new Handler();
handler.postDelayed(new Runnable() {
  @Override
  public void run() {
                //set visibility as gone here
                if(textBox.getVisibility()==View.VISIBLE){
                donutProgress.setVisibility(View.GONE);
                textBox.setVisibility(View.GONE);
                image.setVisibility(View.GONE);
            }
  }
}, 30000);