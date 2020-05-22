public class MainActivity extends Activity {

Button m_toggleButton ;
AudioManager m_audio;
boolean m_isPhoneSilent;

@Override
public void onCreate(Bundle savedInstanceState) 
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
     m_toggleButton = (Button)findViewById(R.id.toggleButton);
    m_audio = (AudioManager)getSystemService(AUDIO_SERVICE);
   ///... your code here