SharedPreferences wmbPreference1;    
SharedPreferences.Editor editor;
@Override
protected void onCreate(Bundle savedInstanceState) {    
super.onCreate(savedInstanceState);
setContentView(R.layout.list_item_activity_1);  
ratingText = (TextView) findViewById(R.id.rating);
((RatingBar) findViewById(R.id.ratingBar1))
.setOnRatingBarChangeListener(this);  
wmbPreference1 = PreferenceManager.getDefaultSharedPreferences(this);      
}

@Override
public void onRatingChanged(RatingBar ratingBar, float rating,
boolean fromTouch) {
final int numStars = ratingBar.getNumStars();
editor = wmbPreference1.edit();
editor.putInt("numStars", numStars);
editor.commit();