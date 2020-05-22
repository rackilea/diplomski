@Override
public View getView(int position, View convertView, ViewGroup parent) {
ViewHolder holder;
if( convertView == null ){
    convertView = LayoutInflater.from(getActivity()).inflate(R.layout.list_view_layout, null);
    holder = new ViewHolder();
    holder.tv=(TextView) convertView.findViewById(R.id.textView);
    holder.iv=(ImageView) convertView.findViewById(R.id.imageView);
    ...
    convertView.setTag(holder);
}else {
    holder = (ViewHolder)convertView.getTag();
}

holder.tv.setText(text1[position]);
holder.iv.setImageResource(text2[position]);
...
//handle with your widgets cached in ViewHolder
return convertView;