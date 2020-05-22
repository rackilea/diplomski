public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ntfi Notifi_engine = new ntfi();
        Notifi_engine.Send_notifi(this, "hi", "welcome", R.drawable.wb_logo);
    }
}