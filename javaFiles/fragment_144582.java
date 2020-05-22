mdatabase.addChildEventListener(new ChildEventListener() {
    @Override
    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
        userlist = new ArrayList<>();
        if (dataSnapshot != null && dataSnapshot.getValue() != null) {
            try {

                    BiodataModel bioModel = dataSnapshot.getValue(BiodataModel.class);
                    userlist.add(bioModel);


            } catch (Exception ex) {
                Log.e("MYERROR", ex.getMessage());
            }
        }
    }