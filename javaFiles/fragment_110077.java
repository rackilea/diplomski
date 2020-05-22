ListAdapter mAdapter = new SimpleCursorAdapter(this,
  android.R.layout.simple_list_item_1,
  cursor,new String[] {TravelOrder.NAME},
  new int[]{android.R.id.text1});


mAdapter.setViewBinder(new SimpleCursorAdapter.ViewBinder() {

    @Override
    public boolean setViewValue(View view, Cursor cursor,int columnIndex) {

        if(view.getId() == android.R.id.text1)
        {
          TextView tvName= (TextView) view;
          //do as you want split here 
           String[] separated = cursor.getString(columnName).split("-");
           separated[0]; // this will contain "Name"
           separated[1]; // this will contain "Group"

           tvName.setText(separated[0]);


         return true;
        }

        return false;
    }
});

listView.setAdapter(mAdapter);