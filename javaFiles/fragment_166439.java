public class SmsViewActivity extends Activity {
    private static final String TAG = "SmsViewActivity";
    private FoodJSONSerializer mSerializer;
    public Button mSaveButton, mDismissButton;
    public int mNotificationId;
    public String message;
    private EditText mTitleField;
    private CheckBox mImperialCheckBox;
    private CheckBox mMetricCheckBox;
    private EditText mServingsField;
    private EditText mDirectionsField;
    private Spinner mMetricSpinner;
    private Spinner mImperialSpinner;
    Food mFood; 

public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_sms);
        mSaveButton = (Button) findViewById(R.id.save_button_sms);
        mDismissButton = (Button) findViewById(R.id.dismiss_button_sms);

            // ------------------------------------------------------------

            // Get extras and display information in view
            //String sender = getIntent().getStringExtra("sender");
            String msg = getIntent().getStringExtra("message");
            try {
                JSONObject jsonRecipe = new JSONObject(msg);
                Food mFood = new Food(jsonRecipe);
                Log.i(TAG, "Food = " + mFood);
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            // -----------------------------------------------------------------------
            mNotificationId = getIntent().getIntExtra("notificationid", 0);
            if (mNotificationId == 0) {
                Log.e(TAG, "Could not retrieve notification ID.");
                Toast.makeText(this, "A fatal error has occurred in SMS viewer.",
                        Toast.LENGTH_LONG).show();
                finish();
            }

            // Cancel the notification
            String ns = Context.NOTIFICATION_SERVICE;
            NotificationManager notificationMgr = (NotificationManager) getSystemService(ns);
            notificationMgr.cancel(mNotificationId);

            // --------------------------------------------------
            mTitleField = (EditText)v. findViewById(R.id.food_title_sms);
            mTitleField.setText(mFood.getTitle());

            mServingsField = (EditText)v. findViewById(R.id.food_servings_sms);
            mServingsField.setText(mFood.getServings());

           mDirectionsField = (EditText)v. findViewById(R.id.directions_text_sms);
            mDirectionsField.setText(mFood.getDirections());


            // --------------------------------------------------

            // Listener for Save button click
            mSaveButton.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {

                    finish();
                }
            });

            // Listener for Dismiss button click
            mDismissButton.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    backToList();

                    finish();
                }
            });
    return v;
        }

        public void backToList() {
            Intent i = new Intent(this, FoodListFragment.class);
            startActivity(i);
        }
    }