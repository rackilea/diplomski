SharedPreferences preferences;
SharedPreferences.Editor spEditor;
int count = 0;

@Override
protected void onCreate(Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    super.onCreate(savedInstanceState);
    setContentView(R.layout.custom_list);

    preferences = getSharedPreferences("place", Context.MODE_PRIVATE);
    spEditor = preferences.edit();
    count = preferences.getInt("count", 0);
    if(count > 0){
       for(int i = 0; i < count; i++){
            list.add(preferences.getString("Value["+i+"]", ""));
       }          
    }

    numList = (ListView) findViewById(R.id.list);
    btnAdd = (Button) findViewById(R.id.btnAdd);
    adapter = new ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1, list);
    numList.setAdapter(adapter);
    btnAdd.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            EditText edit = (EditText) findViewById(R.id.txtItem);
            spEditor.putString("Value["+count+"]", edit.getText().toString());
            spEditor.commit();
            list.add(preferences.getString("Value["+count+"]", ""));
            count += 1;
            spEditor.putInt("count", count);
            adapter.notifyDataSetChanged();

        }
    });
}