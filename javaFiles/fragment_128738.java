if(cdata.getCount()==0) {
  //empty, show alertDialog
  AlertDialog.Builder builder = new AlertDialog.Builder(this);
  builder.setMessage("Search is empty")
   .setCancelable(true)
   .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
       public void onClick(DialogInterface dialog, int id) {
            dialog.cancel();
       }
   });
  AlertDialog alert = builder.create();
} 
else {
  //Not empty, set the adapter or do what you want. 
  empListview.setAdapter(new MyCursorAdapter( getApplicationContext(), R.layout.listview, cdata, fields, names));
}