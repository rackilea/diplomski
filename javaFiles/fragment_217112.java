...
@Override
    public void onDataChange(DataSnapshot dataSnapshot) {
  //POJOS pojos = new POJOS(); // This is create only blank object of POJOS so you are getting null value
 // Get POJOS object and use the values to update the UI
 POJOS pojos = dataSnapshot.getValue(POJOS.class);
       changed_data_view.setText(pojos.getListname());
       owner.setText(pojos.getOwner());
       Log.i("LIST",pojos.getListname());
       Log.i("OWNER",pojos.getOwner());  

    }
    ...