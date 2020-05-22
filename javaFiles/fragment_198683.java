public View getView(int position, View convertView, ViewGroup parent) { 
 ViewHolder holder;      
 if (convertView == null) { 
 convertView = mInflater.inflate(R.layout.lis_item,parent, false);
 holder = new ViewHolder(); 
 holder.tv = (TextView) convertView.findViewById(R.id.name_view);  
 holder.iv = (ImageView)convertView.findViewById(R.id.default_icon_view);              
 convertView.setTag(holder); 
 } else { 
   holder = (ViewHolder) convertView.getTag(); 
 }
  Profile profile = profiles.get(position);
    if (profile.checkDefault()) {
        holder.iv.setImageResource(R.drawable.ic_launcher);
    } else {
        holder.iv.setImageResource(R.drawable.android_icon);
    }
         holder.tv.setText(profile.getName());
 return convertView; 
 }