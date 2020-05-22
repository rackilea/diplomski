public class MainActivity extends AppCompatActivity {

public boolean clicked = false;

@Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      final Button button = (Button) findViewById(R.id.button_id);
      button.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
          if(!clicked){
            methodToExecuteYourTask();
            clicked = true;
          }
        }
      });
  }
}