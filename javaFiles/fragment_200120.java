public class TeacherClassDetail extends AppCompatActivity {

    //in progress. teacher will set their question here and be able to take attendance and other teacher stuff...
    final DatabaseReference fbRef = FirebaseDatabase.getInstance().getReference();
    final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    Button setQuestion;
    Button removeClass;
    TextView tvDetailName;
    TextView tvID;
    TextView tvStart;
    ListView lvDayList;
    ArrayList<String> dList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_class_detail);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, dList);

        lvDayList = (ListView) findViewById(R.id.lvDays);
        setQuestion = (Button) findViewById(R.id.bSetQuestion);
        removeClass = (Button) findViewById(R.id.bRemoveClass);
        tvDetailName = (TextView) findViewById(R.id.tvCDetailName);
        tvID = (TextView) findViewById(R.id.tvCDetailID);
        tvStart = (TextView) findViewById(R.id.tvCDetailStart);

    }

    protected void onStart(){
        super.onStart();

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (TeacherClassDetail.this, android.R.layout.simple_list_item_1, dList);

        lvDayList.setAdapter(adapter);

        final String ID = getIntent().getStringExtra("ID");
        Query query = fbRef.child("Users").child(user.getUid()).child("Hosted Classes").child(ID);

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //getting string values
                Map<String, String> cl = (Map<String, String>) dataSnapshot.getValue();
                //getting arraylist values
                Map<String, ArrayList<String>> days = (Map<String, ArrayList<String>>) dataSnapshot.getValue();
                //getting arraylist of objects(roster)
                Map<String, Map<String, Object>> roster = (Map<String, Map<String, Object>>) dataSnapshot.getValue();

                //assigning that data to variables
                String id = cl.get("classID");
                String className = cl.get("className");
                String gpsLocation = cl.get("gpdLocation");
                String startTime = cl.get("startTime");
                dList.clear();
                dList.addAll(days.get("days”));
                adapter.notifyDataSetChanged();

                              String teacherID = cl.get("teacherID");

                //creating ClassObj for use in student "my classes" list
                ClassObj newClass = new ClassObj(className, id, startTime, dList, gpsLocation);

                tvDetailName.setText("Class Name: " + newClass.getClassName());
                tvID.setText("Class ID: " + newClass.getClassID());
                tvStart.setText("Start Time(MilTime): " + newClass.getStartTime());


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}