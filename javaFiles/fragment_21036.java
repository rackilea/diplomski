public class MainActivity extends Activity {
            ArrayList<String> listVal = new ArrayList<String>();
            public EditText searchKey;
            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                searchKey = (EditText) findViewById(R.id.searchKey);
                ListView spinner = (ListView) findViewById(R.id.listView1);
                listVal.add("Apple");
                listVal.add("Avocado");
                listVal.add("Banana");
                listVal.add("Blueberry");
                listVal.add("Coconut");
                listVal.add("Durian");
                listVal.add("Guava");
                listVal.add("Kiwifruit");
                listVal.add("Jackfruit");
                ListAdapter listAdapter = new ListAdapter(getApplicationContext(), R.layout.list, listVal);
                spinner.setAdapter(listAdapter);
                spinner.setOnItemClickListener(new OnItemClickListener()
                {
                    @Override
                    public void onItemClick(AdapterView<?> arg0, View v, int pos,
                            long id) {
                        // TODO Auto-generated method stub
                        Log.v("listitem_value",values.get(pos));
                        Log.v("EditTextValue",searchKey.getText().toString().trim());
                        Toast.makeText(context, "listitem_value:"+values.get(pos)+"\nEditTextValue:"+searchKey.getText().toString().trim(), Toast.LENGTH_SHORT).show();
                    }
                });
            }

    }