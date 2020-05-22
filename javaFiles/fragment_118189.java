public class PlayAFriend extends ListActivity {
    private static final String TAG = null;



    ParseObject objects;



    @Override
    public void onStart() {
        super.onStart();
        UAirship.shared().getAnalytics();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playafriend);

        final ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser != null) {

            final ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1);
            ListView friendlv = (ListView)findViewById(android.R.id.list);

            Button play = (Button)findViewById(android.R.id.button1);
            play.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub

                }
            });
            friendlv.setAdapter(listAdapter);

            ParseRelation relation = currentUser.getRelation("Friends");

            ParseQuery query = relation.getQuery();

            query.whereEqualTo("username", null);

            query.findInBackground(new FindCallback() {

                @Override
                public void done(List<ParseObject> objects, ParseException e) {
                    // TODO Auto-generated method stub
                    for (int i = 0; i < objects.size(); i++) {
                        ParseObject r = objects.get(i);
                        String name = r.getString("username").toString();

                        listAdapter.add(name);
                    }

                }
            });
        }

    }

}