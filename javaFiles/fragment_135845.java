if (convertView == null) 
    {
        LayoutInflater linflater = LayoutInflater.from(getContext());
        convertView = linflater.inflate(R.layout.your_list_item_view, parent, false);
         viewHolder.textView = (TextView)convertView.findViewById([the id]);
         .
         .
         .

        convertView.setTag(holder);
    }
    else
    {
      holder = (ViewHolder) convertView.getTag();
    }