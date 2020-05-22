public class UserTypeSelectorActivity extends AppCompatActivity {

    //  Firebase Variables
    FirebaseUser firebaseUser;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference firebaseDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("Activity Name", getLocalClassName());

        //  Initializing Firebase Variables
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseDatabaseReference = firebaseDatabase.getReference();

        if (firebaseUser != null) {
            firebaseDatabaseReference.child("my_app_user").child(firebaseUser.getUid())
                    .addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {

                            //  Check user type and redirect accordingly
                            if (dataSnapshot.child("admin").exists()) {
                                Boolean admin = dataSnapshot.child("admin")
                                        .getValue().toString().equals("true");
                                if (admin) {
                                    startActivity(new Intent(UserTypeSelectorActivity.this,
                                            AdminActivity.class));
                                    finish();
                                } else {
                                    startActivity(new Intent(UserTypeSelectorActivity.this,
                                            ClientActivity.class));
                                    finish();
                                }
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                        }
                    });
        }
    }
}