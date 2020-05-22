myReff.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {

            //this will be executed only if my array is changed (So only if my other function have been correctly executed
            setAnotherArray(array_from_database);
            System.out.println("3");
        }