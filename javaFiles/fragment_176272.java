class ListItem {
    private long mId;
    private String mContent;

    public ListItem(final long mId, final String mContent) {
        this.mId = mId;
        this.mContent = mContent;
    }

    public long getId() {
        return mId;
    }

    public String getContent() {
        return mContent;
    }

}

public class adapter_akt extends BaseAdapter {
    private List<ListItem> mData = new ArrayList<>();

    public void setData(List<ListItem> data){
        mData = data;
        notifyDataSetChanged();
    }

    public  ListItem getItem(int position){
        return mData.get(position);
    }

    @Override
    public long getItemId(final int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent);
            ViewHolder h = new ViewHolder();
            h.textView1 = (TextView) convertView.findViewById(android.R.id.text1);
            convertView.setTag(h);
        }

        ViewHolder holder = (ViewHolder)convertView.getTag();
        ListItem item = getItem(position);
        holder.textView1.setText(item.getContent());

        return convertView;
    }

    public int getCount(){
        return mData.size();
    }

    private class ViewHolder{
        TextView textView1;
    }
}