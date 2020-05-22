public class ItemListAdapter extends ArrayAdapter<Item> {

    private ArrayList<Item> mDatas;
    private Context mContext;
    private LayoutInflater mInflater;
    private int mListItemResourceID;

    public ItemListAdapter(
            Context context, int listItemResourceId, ArrayList<Item> items) {
        super(context, listItemResourceId, items);
        mDatas = items;
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
        mListItemResourceID = listItemResourceId;
    }

    class ViewHolder {
        TextView mNameTextView;
        TextView mGrammTextView;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        final Item item = mDatas.get(position);
        final ViewHolder holder;

        if (convertView == null) {
            convertView = mInflater.inflate(mListItemResourceID, parent, false);

            holder = new ViewHolder();
            holder.mNameTextView = (TextView) convertView.findViewById(R.id.textview_name);
            holder.mGrammTextView = (TextView) convertView.findViewById(R.id.textview_gramm);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if (item != null) {
            holder.mNameTextView.setText(item.getName());
            holder.mGrammTextView.setText(item.getGramm());
        }

        return convertView;
    }
}