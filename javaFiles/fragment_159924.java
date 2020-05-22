private DatabaseReference databaseRefer;
private FirebaseDatabase mFirebaseInstance;
private ArrayList<Location> reisDataList = new ArrayList<>();
private MyTripsAdapter myTripsAdapter;

@Override
protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_maps);

    mFirebaseInstance = FirebaseDatabase.getInstance(); //getting instance of FireDatabase

    //getting db reference from specific node, here you're not refering the node
    databaseRefer = mFirebaseInstance.getReference("windfirm/future");  

    ListView listView = (ListView) view.findViewById(R.id.mijnReizenList);

    databaseRefer.addListenerForSingleValueEvent(new ValueEventListener() {

       @Override
       public void onDataChange(DataSnapshot dataSnapshot) {

        // pendingCount is the count for dataSnapshot children
        long[] pendingCount = { dataSnapshot.getChildrenCount() };

       //parsing all the node list data from dataSnapshot
         for (DataSnapshot child : dataSnapshot.getChildren()) {


               String rightLocation = child.child("lat").getValue().toString();
               String leftLocation = child.child("lon").getValue().toString();
               String city = child.child("city").getValue().toString();
               reisDataList.add(new  Location(rightLocation, leftLocation, city)); //adding object to arraylist

            // we loaded a child, check if we're done
               pendingCount[0] = pendingCount[0] - 1;
               if (pendingCount[0] == 0) {
                   myTripsAdapter = new MyTripsAdapter(getContext(), reisDataList);
                  listView.setAdapter(myTripsAdapter);
               }               


           }


       }

       @Override
       public void onCancelled(DatabaseError databaseError) {

       }
   });


  }