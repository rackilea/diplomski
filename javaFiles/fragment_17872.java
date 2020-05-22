@Override
public void onItemClick(AdapterView<?> parent, View v, int pos, long id) {

    TextView textview1 = (TextView) v.findViewById(R.id.text1);
    TextView textview2 = (TextView) v.findViewById(R.id.text2);

    Log.v("textview1",textview1.getText().toString().trim());
    Log.v("textview2",textview2.getText().toString().trim());

}