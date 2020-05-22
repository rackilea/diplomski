public class MainActivity extends AppCompatActivity {
    public boolean switchState = false;
    Button switchbutton ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        switchbutton = (Button) findViewById(R.id.Switch);
    }

    public void Switched(View v){

        if(!switchState){
            switchState = true;
            switchbutton.setText("OFF");
        }else{
            switchState = false;
            switchbutton.setText("ON");
        }
    }
}