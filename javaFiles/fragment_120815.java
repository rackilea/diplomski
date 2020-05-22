public class TableLikeListView extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);     
        String[] data1 = new String[] { "Header1", "data1", "data2" };
        String[] data2 = new String[] { "Header2", "data1", "data2" };
        String[] data3 = new String[] { "Header3", "data1", "data2" };
        String[] data4 = new String[] { "Header4", "data1", "data2" };
        setListAdapter(new MyAdapter(this, R.layout.adapters_tablelikelistview,
                R.id.data1, data1, data2, data3, data4));
    }

    private static class MyAdapter extends ArrayAdapter<String> {

        private String[] data1, data2, data3, data4;

        public MyAdapter(Context context, int resource, int textViewResourceId,
                String[] data1, String[] data2, String[] data3, String[] data4) {
            super(context, resource, textViewResourceId, data1);
            this.data1 = data1;
            this.data2 = data2;
            this.data3 = data3;
            this.data4 = data4;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = super.getView(position, convertView, parent);
            if (position == 0) {
                // header
                v.setBackgroundColor(Color.GREEN);
            } else {
                v.setBackgroundResource(android.R.drawable.list_selector_background);
            }
            TextView t1 = (TextView) v.findViewById(R.id.data1);
            t1.setText(data1[position]);
            TextView t2 = (TextView) v.findViewById(R.id.data2);
            t2.setText(data2[position]);
            TextView t3 = (TextView) v.findViewById(R.id.data3);
            t3.setText(data3[position]);
            TextView t4 = (TextView) v.findViewById(R.id.data4);
            t4.setText(data4[position]);
            return v;
        }

        @Override
        public boolean isEnabled(int position) {        
            return position == 0 ? false : true;
        }       

    }

}