public class wazeefa extends Activity {

//Count Button
TextView txtCount;
ImageView image;
Button btnCount;
Button wmute;
Button wreset;
public static int count=0;
SharedPreferences app_preferences;
MediaPlayer mpButtonClick;
AudioManager audioManager;
public static boolean mutestatus=false;
@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
// The activity is being created.
setContentView(R.layout.wazeefa);




audioManager =
(AudioManager)getSystemService(Context.AUDIO_SERVICE);
//SAVE COUNT
app_preferences = this.getSharedPreferences("myPrefscount", MODE_WORLD_READABLE);


count = app_preferences.getInt("count", 0);

txtCount = (TextView)findViewById(R.id.wcount);
txtCount.setText("This app has been started " + count + " times.");

image = (ImageView) findViewById(R.id.imageview);

txtCount = (TextView)findViewById(R.id.wcount);
txtCount.setText("This app has been started " + count + " times.");

//Button SOUND AND COUNT
mpButtonClick = MediaPlayer.create(this, R.raw.bubble);
//RESET Button
wreset = (Button)findViewById(R.id.wreset);

txtCount = (TextView)findViewById(R.id.wcount);
txtCount.setText(String.valueOf(count));

btnCount = (Button)findViewById(R.id.wclick);

wmute=(Button)findViewById(R.id.wmute);

btnCount.setOnClickListener(new View.OnClickListener() {
public void onClick(View v) {

count++;
if (count > 50) count = 0; image.setImageResource(R.drawable.duroodimage);
if (count > 0) image.setImageResource(R.drawable.duroodimage);
if (count > 9) image.setImageResource(R.drawable.zikrimage);
if (count > 39) image.setImageResource(R.drawable.duroodimage);
txtCount.setText(String.valueOf(count));
mpButtonClick.start();
}
});

wreset.setOnClickListener(new View.OnClickListener() {
public void onClick(View v) {
count = 0;
image.setImageResource(R.drawable.duroodimage);;
txtCount.setText("0");
SharedPreferences.Editor editor = app_preferences.edit();
editor.putInt("count", count);
editor.commit();
}
});


wmute.setOnClickListener(new View.OnClickListener() {
public void onClick(View v) {
if(!mutestatus){
mutestatus=true;
audioManager.setMode(AudioManager.MODE_IN_CALL);
audioManager.setStreamSolo(AudioManager.STREAM_VOICE_CALL, true);
Log.v("'test....",""+mutestatus);
}
else{
mutestatus=false;
audioManager.setMode(AudioManager.MODE_NORMAL );
audioManager.setStreamSolo(AudioManager.STREAM_VOICE_CALL, false);
Log.v("'test....",""+mutestatus);
}
}});
}

@Override
protected void onPause() {
super.onPause();
// save count value here

SharedPreferences.Editor editor = app_preferences.edit();
editor.putInt("count", count);
editor.commit();


}



}