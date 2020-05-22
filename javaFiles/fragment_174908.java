@Override
public View getView(final int position, View convertView, ViewGroup parent) {

    //--init if not re-cycled--
    if (convertView == null) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.row, parent, false);
        convertView.setTag(new ViewHolder(
                (TextView) convertView.findViewById(R.id.label),
                (ImageButton) convertView.findViewById(R.id.del)
        ));
    }

    //--data to set--
    String item = getItem(position);

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            StableArrayAdapter.this.mIdMap.remove(getItem(position));
            StableArrayAdapter.this.notifyDataSetChanged();
        }
    };

    //--set data--
    ViewHolder holder = (ViewHolder) convertView.getTag();
    holder.text.setText(item);
    holder.button.setOnClickListener(listener);
    return convertView;
}

private static class ViewHolder{
    public final TextView text;
    public final Button button;

    private ViewHolder(TextView text, Button button) {
        this.text = text;
        this.button = button;
    }
}