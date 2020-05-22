@Override
public void onItemSelected(AdapterView<?> parent,View view,int position,long id) {
  // get Array from xml 
  String [] dataArray = getResources().getStringArray(R.array.destination_array);
  String type = dataArray[position];
}