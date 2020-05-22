public class EditTextListActivity extends ListActivity {

    private static final String SAVED_STATE_KEY = "saved_state_key";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EditTextAdapter editTextAdapter = new EditTextAdapter(this, R.layout.main);
        setListAdapter(editTextAdapter);

        // Restore our state, if there is any
        if (savedInstanceState != null) {
            List<String> savedStrings = savedInstanceState.getStringArrayList(SAVED_STATE_KEY);
            for (String savedString : savedStrings)
                editTextAdapter.add(new ListItem(savedString));
        } else {
            // Add some empty items so that we can see it in action
            for (int i = 0; i < 30; i++)
                editTextAdapter.add(new ListItem(""));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        ArrayList<String> arrayList = new ArrayList<String>();
        EditTextAdapter editTextAdapter = (EditTextAdapter) getListAdapter();
        for (int i = 0; i < editTextAdapter.getCount(); i++)
            arrayList.add(editTextAdapter.getItem(i).string1);
        outState.putStringArrayList(SAVED_STATE_KEY, arrayList);
    }

    /**
     * The object we have a list of, probably more complex in your app
     */
    static class ListItem {
        public String string1;

        ListItem(String string1) {
            this.string1 = string1;
        }
    }

    /**
     * ViewHolder which also tracks the TextWatcher for an EditText
     */
    static class ViewHolder {
        public TextView textView;
        public EditText editText;
        public TextWatcher textWatcher;
    }

    class EditTextAdapter extends ArrayAdapter<ListItem> {
        EditTextAdapter(Context context, int resource) {
            super(context, android.R.layout.simple_list_item_single_choice);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View rowView = convertView;
            if (rowView == null) {
                // Not recycled, inflate a new view
                rowView = getLayoutInflater().inflate(R.layout.main, null);
                ViewHolder viewHolder = new ViewHolder();
                viewHolder.textView = (TextView) rowView.findViewById(R.id.textview);
                viewHolder.editText = (EditText) rowView.findViewById(R.id.edittext1);
                rowView.setTag(viewHolder);
            }

            ViewHolder holder = (ViewHolder) rowView.getTag();
            // Remove any existing TextWatcher that will be keyed to the wrong ListItem
            if (holder.textWatcher != null)
                holder.editText.removeTextChangedListener(holder.textWatcher);

            final ListItem listItem = getItem(position);

            // Keep a reference to the TextWatcher so that we can remove it later
            holder.textWatcher = new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    listItem.string1 = s.toString();
                }

                @Override
                public void afterTextChanged(Editable s) {
                }
            };
            holder.editText.addTextChangedListener(holder.textWatcher);

            holder.editText.setText(listItem.string1);
            holder.textView.setText(Integer.toString(position));

            return rowView;
        }
    }
}