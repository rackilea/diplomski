package com.example.textspeech;

   import java.util.Locale;

  import android.app.Activity;
  import android.os.Bundle;
   import android.speech.tts.TextToSpeech;

   public class MainActivity extends Activity {
TextToSpeech mTextToSpeech;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mTextToSpeech = new TextToSpeech(getApplicationContext(),
            new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int status) {
                    mTextToSpeech.setLanguage(Locale.UK);
                    mTextToSpeech.speak("You will use Eclipse IDE to create an Android application and name it as TextToSpeech under a package", TextToSpeech.QUEUE_FLUSH, null);
                }
            });
}