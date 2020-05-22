private void updateList() {


    ListView lv = getListView();
    ListAdapter adapter = new SimpleAdapter(this, mCommentList,
            R.layout.single_post, new String[] { TAG_SEATNUMBER, TAG_DRINKSORDERED
            //TAG_DRINKSORDERED, TAG_SERVICES
                     }, new int[] { R.id.seatnumber, R.id.orders
            //R.id.drinkstv, R.id.servicestv,


     });

    setListAdapter(adapter);
    lv.setOnItemClickListener(new OnItemClickListener() {

        @Override
        public boolean onItemClick(AdapterView<?> arg0, View arg1,
                final int arg2, long arg3) {
            // TODO Auto-generated method stub

            AlertDialog.Builder alt = new AlertDialog.Builder(
                    YourActivityName.this,
                    android.R.style.Theme_DeviceDefault_Dialog);
            alt.setMessage("Are you sure want to delete this file??");
            alt.setPositiveButton("Yes",
                    new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog,
                                int which) {
                            // TODO Auto-generated method stub
                            mCommentList.remove(arg2);

                            adapter.notifyDataSetChanged();
                        }
                    });

            alt.setNegativeButton("No",
                    new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog,
                                int which) {
                            // TODO Auto-generated method stub

                            dialog.dismiss();

                        }
                    });
            AlertDialog dialog = alt.create();
            dialog.show();

            return true;
        }
    });
}