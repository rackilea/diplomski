@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    findViewById(R.id.myimage).setOnTouchListener(new OnTouchListener() {
        @Override
        public boolean onTouch (View v, MotionEvent event) {
            int x = (int)(event.getX());
            int y = (int)(event.getY());
            City tempCity = new City(x,y);
            TourManager.addCity(tempCity);
            return true;
        }
     });
}