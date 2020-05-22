listhope.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


  //position is the row on which the user has clicked


     ParseUser parseUser=mUsers.get(position);
      //now you have the objext parseUser and this objects is what you needed.


        }


    });