@Override
protected void onCreate(Bundle savedInstanceState) {

super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
Firebase.setAndroidContext(this);
Firebase ref = new Firebase("https://fbandg.firebaseio.com");
final TextView textbox = (TextView) findViewById(R.id.textbox);
ref.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {

        fObject fobject = new fObject();
        fobject.setNewCondition(dataSnapshot.child("condition").getValue().toString());
        textbox.setText(fobject.getNewCondition());
    }

    @Override
    public void onCancelled(FirebaseError firebaseError) {

    }
});