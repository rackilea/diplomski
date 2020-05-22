if (convertView != null) { 
    holder = (ViewHolder) convertView.getTag(); 
} else { 
    convertView = inflater.inflate(resource, parent, false); 
    holder = new ViewHolder();
    holder.nameTextView = convertView.findViewById(R.id.nameTextView); 
    holder.priceTextView = convertView.findViewById(R.id.priceTextView); 
    holder.plusButton = convertView.findViewById(R.id.plusButton); 
    holder.minusButton = convertView.findViewById(R.id.minusButton); 
    holder.numberTextView = convertView.findViewById(R.id.numberTextView); 
    convertView.setTag(holder);
}