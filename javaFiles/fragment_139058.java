class CustomAdapter extends BaseAdapter {

    private ArrayList<String>   mList;
    private LayoutInflater      mInflater;
    public CustomAdapter(ArrayList<String> list) {
        mList = list;
        mInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {

        return mList.size() ;
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) 
            convertView = mInflater.inflate(R.layout.lv_row, null);
    ((TextView) convertView.findViewById(R.id.label2)).setText(mList.get(position));
    return convertView;
    }
}