public class MainActivity extends ListActivity {

   /*
     current code
   */

    public void onCreate(Bundle savedInstanceState) {
     //
     //

       setListAdapter(new SampleAdapter(this,
            android.R.layout.simple_list_item_1,
            mSamples));
    }

    @Override
    protected void onListItemClick(ListView listView, View view, int position, long id) {
        // Launch the sample associated with this list position.
        startActivity(new Intent(MainActivity.this, mSamples[position].activityClass));
    }

    public static class SampleAdapter extends ArrayAdapter<Sample>{

            SampleAdapter(Context context, int resource, Sample[] objects) {
                super(context, resource, objects);
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View rootView = super.getView(position, convertView, parent);
                TextView firstLine = rootView.findViewById(R.id.list_item_entry_title);
                TextView secondLine = rootView.findViewById(R.id.list_item_entry_summary);
                firstLine.setText(getItem(position)./*Sample class field*/);
                secondLine.setText(getItem(position)./*Sample class field*/);
                return rootView;
            }
        }
}