@Override
public View getView(int position, View convertView, ViewGroup parent) {
    final View view = View.inflate(context, R.layout.item_list, null);

    if (position == mSelectedItem) {
        // set your color
    }

    return view;
}