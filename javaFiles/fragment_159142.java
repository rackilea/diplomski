public class MainActivity extends Activity {

private ListView lvItems;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    lvItems = (ListView) findViewById(R.id.lvItems);
    String[] locationsArray = getResources().getStringArray(
            R.array.locations_array);
    CustomAdapter adapter = new CustomAdapter(this, locationsArray);
    lvItems.setAdapter(adapter);

lvItems.setOnItemClickListener(new OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View view,
                int position, long id) {
            ViewHolder holder = (ViewHolder) view.getTag();
            String item = holder.getItem();
            // Do what ever with your Item.
            // If You need the position, you can take it from above
            // position.
        }
    });
}

}