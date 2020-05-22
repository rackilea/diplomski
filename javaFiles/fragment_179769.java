public class RecogActivity extends AppCompatActivity {

   private Button voiceBtn;

   @Override
   protected void onCreate(Bundle savedInstanceState) {

      super.onCreate(savedInstanceState);
      // set the layout first
      setContentView(R.layout.YOUR_LAYOUT_XML_FILE_NAME)

      voiceBtn = findViewById(R.id.goToVoice);

      // some unrelated code

      configureActivitySwap();
 }

 public void configureActivitySwap(){
    // Button voiceBtn = (findViewById(R.id.goToVoice));

    voiceBtn.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View view) {
        finish();
    }
  });
}