public class MainActivity extends AppCompatActivity {

    int correctNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int correctNumber = generateNum(); 
    }

// ...
}