//Listener.java
public class Listener implements RecognitionListener() {
 MainActivity instance;
 public Listener(MainActivity mainActivity){
        this.instance = mainActivity;
 }
  public void onResults(Bundle 
    MainActivity theMainActivity = new MainActivity();

    //the following line always breaks the code:
    tts = new TextToSpeech(instance, new TextToSpeech.OnInitListener() {/*...*/});
  }
}
//MainActivity.java
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
  private SpeechRecognizer sr;
  sr.setRecognitionListener(new Listener(this));
}