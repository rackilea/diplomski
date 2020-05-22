public class EntryListAdapter extends ArrayAdapter<Entry> {

    Context ctx;
    List<Entry> entryList;
    LayoutInflater inflater;

    public AccountListAdapter(Context context, ArrayList<Entry> entryList) {
        super(context, R.layout.entry_list_row, entryList);
        ctx = context;
        accountList = accList;
        inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null) {
            Account account = accountList.get(position);
            convertView = inflater.inflate(R.layout.account_list_row, parent, false);

            TextView entryListEntryIDTextView =  (TextView) convertView.findViewById(R.id.entryListEntryIDTextView);
            entryListEntryIDTextView.setText(entry.getID());
            //Do this for all other TextViews. For all the information you want to show up
        }
        return convertView;
    }
}