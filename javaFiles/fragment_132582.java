@Override
public View getView(int pos, View convertView, ViewGroup parent) {
    ViewHolder holder;

    if(convertView == null || convertView.getTag() == null){
        convertView = inflater.inflate(R.layout.list_item, parent, false);
        holder = new ViewHolder();

        holder.text1  = (TextView)convertView.findViewById(R.id.list_item_text1);
        holder.text2  = (TextView)convertView.findViewById(R.id.list_item_text2);
        holder.text1.setTypeface(YourApp.Fonts.THEOREM); // only happens once when recycling!

        convertView.setTag(holder);
    }else{
        holder = (ViewHolder) convertView.getTag();
    }

    holder.text1.setText("someText");
    holder.text2.setText("someText");
    return convertView;
}