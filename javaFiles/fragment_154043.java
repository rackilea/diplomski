listview.setOnItemClickListener(new OnItemClickListener() {
  @Override
public void onItemClick(AdapterView<?> arg0,View arg1, int arg2, long arg3) {

String requiredvalue= ((TextView) arg1.findViewById(R.id.viewid)).getText().toString();
Log.i("requiredvalue", requiredvalue);

}