public class LunchList extends Activity
{
    List<String> model = new ArrayList<String>();
    ArrayAdapter<String> adapter = null;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch_list);
        Button save = (Button) findViewById(R.id.button1);
        save.setOnClickListener(onSave);
        ListView list = (ListView) findViewById(R.id.restaurants);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, model);
        list.setAdapter(adapter);
    }

    private View.OnClickListener onSave = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            Restaurant r = new Restaurant();
            EditText name = (EditText) findViewById(R.id.name);
            EditText address = (EditText) findViewById(R.id.addr);
            r.setName(name.getText().toString());
            r.setAddress(address.getText().toString());
            RadioGroup types = (RadioGroup) findViewById(R.id.type);
            switch ( types.getCheckedRadioButtonId() )
            {
                case R.id.sit_down:
                    r.setType("sit_down");
                    break;
                case R.id.take_out:
                    r.setType("take_out");
                    break;
                case R.id.delivery:
                    r.setType("delivery");
                    break;
            }
            model.add(r.getType());
            adapter.notifyDataSetChanged();
        };
    };
}