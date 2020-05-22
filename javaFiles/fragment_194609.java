lstContent.setOnItemClickListener(new OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

        TextView txtView1 = (TextView) arg1.findViewById(R.id.txtTitle);  //first TextView
        String text1 = txtView1.getText().toString();
        TextView txtView2 = (TextView) arg1.findViewById(R.id.txtView2);  //second TextView
        String text2 = txtView2.getText().toString();
        Log.i("Log_five", text1);
        Log.i("Log_five", text2);
    }
});