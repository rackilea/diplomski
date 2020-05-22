class ContactsAdapter extends BaseAdapter implements Filterable {

    private List<Contact> mData;
    private List<Contact> database;
    private LayoutInflater mInflater;
    private Context context;
    static boolean inMarkMode = false;

    ContactsAdapter(List<Contact> mData, List<Contact> database, Context context) {
        this.mData = mData;
        this.context = context;
        this.database = database;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    /**
     * Modifies the way a contact is shown in its adapter depending on
     * displayChoice shared preference
     * 
     * @param position
     *            of the contact in its listview
     * @return <code>String</code> to display
     */
    @Override
    public String getItem(int position) {
        switch (context.getSharedPreferences("settings",
                HomeScreenActivity.MODE_PRIVATE).getInt("displayChoice", -1)) {
        case 1:
            return mData.get(position).getLastName() + " "
                    + mData.get(position).getFirstName();
        case 2:
            return mData.get(position).getFirstName() + " "
                    + mData.get(position).getMobileNumber();
        case 3:
            return mData.get(position).getLastName() + " "
                    + mData.get(position).getMobileNumber();
        default:
            return mData.get(position).getFirstName() + " "
                    + mData.get(position).getLastName();
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * Modifies the view shown in HomeScreenActivity depending on whether the
     * user has entered mark mode or not
     * 
     * @return <code>View</code> to display
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        CheckedTextView result = null;
        TextView normalResult = null;
        final String contactRow = getItem(position);

        if (inMarkMode) {// if user is in markMode, use the mark layout
            if (convertView == null) {
                result = (CheckedTextView) mInflater.inflate(
                        R.layout.home_screen_contacts_mark_view, parent, false);
            } else {
                result = (CheckedTextView) convertView;
            }
            result.setText(contactRow);
            result.setBackgroundResource(R.drawable.list_selector);
        } else { // if user NOT in markmode, use normal contacts view layout
            if (convertView == null) {
                normalResult = (TextView) mInflater.inflate(
                        R.layout.home_screen_contacts_view, parent, false);
            } else {
                normalResult = (TextView) convertView;
            }
            normalResult.setText(contactRow);
            normalResult.setBackgroundResource(R.drawable.list_selector);
        }

        if (inMarkMode) {
            return result;
        } else {
            return normalResult;
        }
    }

    int getItemIdAtPosition(int position) {
        return mData.get(position).getID();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                FilterResults results = new FilterResults();
                // If there's nothing to filter on, return the original data for
                // your list
                if (charSequence == null || charSequence.length() == 0) {
                    results.values = database;
                    results.count = database.size();
                } else {
                    List<Contact> filterResultsData = new ArrayList<Contact>();

                    // if search details is 0, search fullName, else, search
                    // all details
                    if (HomeScreenActivity.searchAllDetails == 0) {
                        for (Contact c : database) {
                            if (c.getFullName().toLowerCase(Locale.ENGLISH)
                                    .contains(charSequence)) {
                                filterResultsData.add(c);
                            }
                        }
                    } else {
                        for (Contact c : database) {
                            if (c.getAllDetailsForSearch()
                                    .toLowerCase(Locale.ENGLISH)
                                    .contains(charSequence)) {
                                filterResultsData.add(c);
                            }
                        }
                    }

                    results.values = filterResultsData;
                    results.count = filterResultsData.size();
                }

                return results;
            }

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence charSequence,
                    FilterResults filterResults) {
                // set the data to the filter results and notifyDataSetChanged()
                mData = (List<Contact>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}