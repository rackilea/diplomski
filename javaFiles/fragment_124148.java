@Override
protected void onListItemClick(ListView l, View v, int position, final long id){
super.onListItemClick(l, v, position, id);

final My_DownLoad my_dl = (My_DownLoad) map_thoughts.get(my_list.get(position));
final Intent i = new Intent(this, NextActivity.class);

l.setOnItemLongClickListener(new OnItemLongClickListener(){
        public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3){

        }

        @Override
        public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                int arg2, long arg3) {

            //add values to intent
            startActivity(i);

            return false;
        }
    });



 }