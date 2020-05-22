ListView lv = (ListView)findViewById(R.id.your_id);
                    lv.setLongClickable(true);
                    lv.setOnLongClickListener(new OnLongClickListener(){

                    @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view,
                 int position,  long id) {
                                     AlertDialog.Builder aat = new AlertDialog.Builder(this);
        aat.setTitle("Delete?")
                .setMessage("Are you sure you want to delete "+parent.getItemAtPosition(position).toString()+"?")
                .setCancelable(true)
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        dialog.cancel();
                    }

                })
                .setPositiveButton("Delete", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub

                       HabitDbHelper helper = new HabitDBHelper(this);

                        helper.delete(position);


                        helper.close();
                        onCreate(null);//call it here to refresh listView upon delete

    }
});
 AlertDialog art = aat.create();

 art.show();

           }

          });