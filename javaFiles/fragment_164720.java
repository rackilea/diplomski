//Declare these variable 
private Handler handler;
private Runnable updateView;


private void setVisibilityTimerOn(){
     timeHandler = new Handler(); //it's better if you declare this line in onCreate (becuase if user press stopButton first before pressing startButton error will occur as handler was never initialized and you try calling removeCallback function)
     updateView = new Runnable() {
         public void run() {
              someImageView.setVisibility(View.VISIBLE);
         }
     };
     handler.postDelayed(updateView ,90000);//this will be on after 90 second
}

private void setVisibilityTimerOff(){
    handler.removeCallbacks(updateView);
}