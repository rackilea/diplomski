public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.editTextTest).setFocusable(false);

        findViewById(R.id.buttonTest).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                // get view
                View view = findViewById(R.id.editTextTest);
                view.setDrawingCacheEnabled(true);

                // get height and width from scroll view
                ScrollView scrollView = (ScrollView)findViewById(R.id.scroolView);
                int totalHeight = scrollView.getChildAt(0).getHeight();
                int totalWidth = scrollView.getChildAt(0).getWidth();

                // set view
                view.layout(0,0,totalWidth,totalHeight);

                // build drawing cache
                view.buildDrawingCache(true);

                // bitmap storage
                Bitmap bmp = Bitmap.createBitmap(view.getDrawingCache());

                // clear cache
                view.setDrawingCacheEnabled(false);

                // convert bitmap to byte array
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArrayBitmap = stream.toByteArray();

                // show fragment
                SupportDialogFragment fragment
                        = SupportDialogFragment.newInstance(
                        3 + 1,
                        1 + 2,
                        false,
                        false,
                        true,
                        false,
                        "Keep Trying Make Something Awesome !!!",
                        byteArrayBitmap

                );
                fragment.show(getSupportFragmentManager(), "blur_sample");

                return true;
            }
        });


    }