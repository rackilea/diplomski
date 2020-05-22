public class AbDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abdetails);

        if (getIntent() != null && getIntent().getExtras() != null) {
            Bundle bundle = getIntent().getExtras();
            int position = bundle.getInt("POSITION", 0);

            switch (position) {
                case 0:
                    // Load video 0
                    break;

                case 1:
                    // Load video 1
                    break:
                ...
        }
    }
}