@Override
protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_play);
 Intent intent = getIntent();
 Runnable doUpdateTimeSlider = new Runnable() {
     @Override
     public void run() {
         timeSliderHandler.postDelayed(doUpdateTimeSlider, timeSliderInterval);
         updateTimeSlider();
     }
 };
}//<--------HERE

 void startUpdateTimeSlider() {
     doUpdateTimeSlider.run();
 }