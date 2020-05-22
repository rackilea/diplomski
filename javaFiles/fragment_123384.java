private class MyListAdapter extends BaseAdapter {
...
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView tv;
        if (convertView == null) {
            tv = (TextView) LayoutInflater.from(mContext).inflate(
                    android.R.layout.simple_expandable_list_item_1, parent, false);
        } else {
            tv = (TextView) convertView;
        }
        tv.setText(mStrings[position]);
        return tv;
    }
...
}