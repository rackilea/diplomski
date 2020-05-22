public View getView(int position, View convertView, ViewGroup parent) {

    Holder holder = new Holder();
    View rowView;

    rowView = inflater.inflate(R.layout.cantos_list, null);
    holder.tv = (TextView) rowView.findViewById(R.id.textCanto);
    holder.tv.setText(result[position]);

    Typeface myTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/AftaSerifThin-Regular.otf");
    holder.tv.setTypeface(myTypeface);

    return rowView;
}