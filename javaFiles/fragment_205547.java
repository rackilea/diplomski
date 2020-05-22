@Override
public View getView(int position, View convertView, ViewGroup parent) {         
   ViewHolder holder = null;
   LayoutInflater inflater = getLayoutInflater();
      if (convertView == null) {
         convertView = inflater.inflate(R.layout.row, null, false);
         holder = new ViewHolder(convertView);
         convertView.setTag(holder);
      }
      else {
         holder = (ViewHolder) convertView.getTag();
      }     
      holder.getUpperText().setText(dataSource[position]);
      holder.getLowerText().setText(dataSource[position]);

   return convertView;  
}