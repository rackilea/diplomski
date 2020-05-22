public class MainActivity extends AppCompatActivity {
    private LinearLayout root;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        root = new LinearLayout(this);
        setContentView(root);
    }
}