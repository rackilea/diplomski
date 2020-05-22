final FirebaseDatabase database = FirebaseDatabase.getInstance();
final DatabaseReference myReff = database.getReference();

  myReff.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {

          DatabaseReference ref2 = database.getReference();

          //Take the array from my database (gived in parameter)
          final ArrayList<Integer> array = array_from_database;
           System.out.println("2");

        array.set(0,3);

        Map<String, Object> chemainChild = new HashMap<>();
        chemainChild.put("server/user/",array);

        myReff.updateChildren(chemainChild);

            System.out.println("3");
        }