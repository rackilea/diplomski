public class MainActivity extends AppCompatActivity {
    Round[] round;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Thread(new Runnable() {
            @Override
            public void run() {
                round = new Round[4];
                for(int i = 0; i < 4; i++){
                    round[i] = new Round();
                    round[i].initialize();
                }
            }
        }).start();
    }
}