public class StackoverflowActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.main);

        LinearLayout mainLayout = (LinearLayout) findViewById(R.id.mainLayout);
        LayoutInflater li =  (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        for (int i = 0; i < 5;  i++){
               View tempView = li.inflate(R.layout.list_template, null);

               TextView list_textView = (TextView) tempView.findViewById(R.id.list_textView);
               list_textView.setText("TextView"+i);

               Button list_button = (Button) tempView.findViewById(R.id.list_button);
               list_button.setText("Button"+i);
               list_button.setId(i);

               list_button.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    //Button clicked
                    Toast.makeText(StackoverflowActivity.this, "Button" + v.getId() + " clicked", Toast.LENGTH_SHORT).show();
                }
            });
               mainLayout.addView(tempView);
            }
    }
}