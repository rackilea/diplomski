public class LayoutActivity extends Activity {

  int song;
  MediaPlayer mediaPlayer;

  public void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.layout);

    RadioGroup radgrp = (RadioGroup) findViewById(R.id.radiogroup);
    radgrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

      @Override
      public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
          case R.id.dance:
            song = R.raw.redalert;
            break;
          case R.id.rap:
            song = R.raw.cannedheat;
            break;
          case R.id.rock:
            song = R.raw.movmou8105;
            break;
        }


        mediaplayer = MediaPlayer.create(LayoutActivity.this, song);
        try {
          mediaplayer.prepare();
          mediaplayer.start();
        } catch (IllegalStateException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    });
  }
}