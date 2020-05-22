MainActivity.CustomAdapter customAdapter = new MainActivity.CustomAdapter();
 customAdapter.setOnListItemClickListener(new OnListItemClickListener()
 {
 @override
 void onListItemClicked(View view,int position)
 {

 //then here place your desired action
 }
 });
                    lastComments.setAdapter(customAdapter);