public class MainActivity extends AppCompatActivity {
    String filename ="Testing-app-file.txt";
    File path;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        path = this.getFilesDir();
    }

    ...