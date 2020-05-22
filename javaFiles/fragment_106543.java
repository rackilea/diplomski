public class MainActivity extends AppCompatActivity {
private Context mContext;


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    final FloatingActionButton button = (FloatingActionButton) findViewById(R.id.fab);
    button.setOnClickListener(new View.OnClickListener() {
        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
        @SuppressLint("SetTextI18n")
        public void onClick(View v) {

            RelativeLayout rl = (RelativeLayout) findViewById(R.id.li);
            mContext = getApplicationContext();



            //card view
            CardView card = new CardView(mContext);
            // Set the CardView layoutParams
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.MATCH_PARENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT
            );
            card.setLayoutParams(params);

            // Set CardView corner radius
            card.setRadius(9);
            // Set cardView content padding
            card.setContentPadding(15, 50, 15, 50);
            // Set a background color for CardView
            card.setCardBackgroundColor(Color.parseColor("#ffffff"));
            // Set the CardView maximum elevation
            card.setMaxCardElevation(15);
            // Set CardView elevation
            card.setCardElevation(9);

            RelativeLayout layout = new RelativeLayout(MainActivity.this);

            RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);


            // Add edittext1
            EditText et1 = new EditText(MainActivity.this);
            et1.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT));
            et1.setHint("Your Question");

            et1.setId(View.generateViewId());
            //textView1.setBackgroundColor(0xff66ff66); // hex color 0xAARRGGBB
            //textView1.setPadding(20, 20, 20, 20);// in pixels (left, top, right, bottom)
            layout.addView(et1,params1);

            // Add edittext 2
            EditText et2 = new EditText(MainActivity.this);
            et2.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT));
            et2.setHint("Your Answer");
            params2.addRule(RelativeLayout.BELOW, et1.getId());
            layout.addView(et2,params2);

            card.addView(layout)
            rl.addView(card );


        }
    });

}

}