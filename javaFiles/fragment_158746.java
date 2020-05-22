@Override
public void onResume(){
    super.onResume();
    try{
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, myStringList.toArray(), android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
    } catch (RuntimeException e){
        Log.d("error",e+"");
    }
}