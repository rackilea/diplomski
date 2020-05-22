public class testActivity extends Activity {

    private static final String[] COUNTRIES = new String[] { "Belgium",
            "France", "Italy", "Germany", "Spain" };
    private Spinner mySpinner;
    private Typeface myFont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newlay);

        mySpinner = (Spinner) findViewById(R.id.spinner1);
        myFont = Typeface.createFromAsset(getAssets(), "gujarti.ttf");
        MyArrayAdapter ma = new MyArrayAdapter(this);
        mySpinner.setAdapter(ma);
    }

    private class MyArrayAdapter extends BaseAdapter {

        private LayoutInflater mInflater;

        public MyArrayAdapter(testActivity con) {
            // TODO Auto-generated constructor stub
            mInflater = LayoutInflater.from(con);
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return COUNTRIES.length;
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            final ListContent holder;
            View v = convertView;
            if (v == null) {
                v = mInflater.inflate(R.layout.my_spinner_style, null);
                holder = new ListContent();

                holder.name = (TextView) v.findViewById(R.id.textView1);

                v.setTag(holder);
            } else {

                holder = (ListContent) v.getTag();
            }

            holder.name.setTypeface(myFont);
            holder.name.setText("" + COUNTRIES[position]);

            return v;
        }

    }

    static class ListContent {

        TextView name;

    }
}