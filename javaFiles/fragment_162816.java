public View getView(int position, View convertView, ViewGroup parent){
    inflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    View v =convertView;
    if (v == null) {

        holder=new ViewHolder();
        v=inflater.inflate(Resource,null);
        holder.name= (TextView) v.findViewById(R.id.titles);
        holder.price= (TextView) v.findViewById(R.id.price);
        holder.img= (ImageView) v.findViewById(R.id.itemimage);
        v.setTag(holder);
    }
    else {
        holder = (ViewHolder) v.getTag();
    }

        holder.name.setText(list1.get(position).getName());
        holder.price.setText((CharSequence) list1.get(position).getPrice());
        holder.img.setImageBitmap(list1.get(position).getImage());    

    return v;
}