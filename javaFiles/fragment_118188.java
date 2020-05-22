public class Findfriends extends Activity {

    protected static final String TAG = null;

    ParseObject po;

    @Override
    public void onStart() {
        super.onStart();
        UAirship.shared().getAnalytics();

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.findfriends);

        final EditText sbar = (EditText)findViewById(R.id.PlayerSeachBar);
        Button search = (Button)findViewById(R.id.Search);
        Button Add = (Button)findViewById(R.id.Add);
        final TextView ResultText = (TextView)findViewById(R.id.ResultTextView);
        final FrameLayout ResultFrame = (FrameLayout)findViewById(R.id.ResultFrameLayout);

        ResultFrame.setVisibility(View.GONE);

        search.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                final String username = sbar.getText().toString();

                final ParseQuery query = ParseUser.getQuery();
                query.whereEqualTo("username", username);
                query.findInBackground(new FindCallback() {

                    @Override
                    public void done(List<ParseObject> objects, ParseException e) {
                        // TODO Auto-generated method stub
                        try {
                            ParseObject userObject = objects.get(0);
                            ResultText.setText(userObject.getString("username"));
                            ResultFrame.setVisibility(View.VISIBLE);

                            Toast.makeText(getApplicationContext(), "Player Found",
                                    Toast.LENGTH_LONG).show();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            Toast.makeText(getApplicationContext(), "Username Not Found",
                                    Toast.LENGTH_LONG).show();
                        }

                    }
                });

            }
        });

        Add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String Friends = sbar.getText().toString();
                final ParseUser currentUser = ParseUser.getCurrentUser();
                if (currentUser != null) {
                    {

                        final ParseObject friend = new ParseObject("Friends");
                        friend.put("username", Friends);

                        friend.saveInBackground(new SaveCallback() {

                            @Override
                            public void done(ParseException e) {
                                // TODO Auto-generated method stub
                                ParseRelation relation = currentUser.getRelation("Friends");
                                relation.add(friend);
                                currentUser.saveInBackground();
                            }

                        });

                        Toast.makeText(getApplicationContext(), "Player Has Been Added",
                                Toast.LENGTH_LONG).show();

                    }
                }

            }
        });

    }

    @Override
    public void onStop() {
        super.onStop();

    }
}