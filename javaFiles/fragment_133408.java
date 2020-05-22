@Override
public View getView(int position, View convertView, ViewGroup parent) {

    if(getItemId(position) == TEST_VIEW_ID) {
        TestViewModel viewModel = (TestViewModel) getItem(position);

        TestRow row;
        if(convertView == null) {
            convertView = this.inflater.inflate(TestRow.LAYOUT, parent, false);
            row = new TestRow(convertView); // Here the magic happens
            convertView.setTag(row);
        }

        row = (TestRow) convertView.getTag();
        row.bind(viewModel);
    }

    return convertView;
}