public class MainActivity extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ListView listView = (ListView) findViewById(R.id.listView);
        final ArrayList<Entry> entries = new ArrayList<Entry>();

        entries.add(new Entry("Linsey Sexton", "Hey baby, I love you..."));
        entries.add(new Entry("Joe Schmoe", "<Insert standard response here>"));
        entries.add(new Entry("Linsey Sexton", "Joe, what are you saying?!"));
        entries.add(new Entry("Joe Schmoe", "We're done, baby!"));

        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.list_item, R.id.textView_Name, entries)
        {
            @Override
            public View getView(int position, View convertView, ViewGroup parent)
            { 
                View view = super.getView(position, convertView, parent);
                ImageView image = (ImageView) view.findViewById(R.id.imageView1);
                TextView text1 = (TextView) view.findViewById(R.id.textView_Name);
                TextView text2 = (TextView) view.findViewById(R.id.textView_RecentMessage);
                image.setImageResource(R.drawable.ic_launcher);
                text1.setText(entries.get(position).name); 
                text2.setText(entries.get(position).message); 
                return view;
            }
        };

        listView.setAdapter(adapter);
    }

    class Entry
    {
        String name;
        String message;

        public Entry(String name, String message)
        {
            this.name = name;
            this.message = message;
        }
    }
}