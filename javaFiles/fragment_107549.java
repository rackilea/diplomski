public class CusatomeAdapter extends BaseAdapter {
    public ArrayList<String> mList1;
    public ArrayList<String> mList2;
    Activity activity;

    public CusatomeAdapter(Activity activity,ArrayList<String> mList1 , ArrayList<String> mList2){
        super();
        this.activity = activity;
        this.mList1 = mList1;
        this.mList2 = mList2;
    }

    @Override
    public int getCount() {
        return mList1.size();   //give the size of list here
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater = activity.getLayoutInflater();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.row_detail, null);
            holder = new ViewHolder();
            holder.tv_detail = (TextView) convertView.findViewById(R.id.tv_detail);

            //same way define another text view and set their value ..

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tv_detail.setText(mList1.get(position).toString());
        return convertView;
    }

    private class ViewHolder {
        TextView tv_detail;
    }
}