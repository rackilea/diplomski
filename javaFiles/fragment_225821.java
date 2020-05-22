...
    int type=getViewType();
    switch(type)
      {
      case 0:
        if(row == null)
          {
          row = inflater.inflate(layoutResourceId, parent, false);
          holder = new WeatherHolder();
          holder.imgIcon = (ImageView)row.findViewById(R.id.imgIcon);
          holder.txtTitle = (TextView)row.findViewById(R.id.txtTitle);
          row.setTag(holder);
          }
        else 
          holder = (WeatherHolder)    row.getTag();
        ContactItem contactItem = (ContactItem)i;
        holder.txtTitle.setText(contactItem.title);
        holder.imgIcon.setImageBitmap(contactItem.icon);   
        break;
      case 1:
        if(row == null)
          {
          row = inflater.inflate(R.layout.listview_header_row, parent, false);
          holder2 = new SectionHolder();
          holder2.txtTitle = (TextView)row.findViewById(R.id.txtTitle);
          row.setTag(holder2);
          }
        else 
          holder2 = (SectionHolder)   row.getTag();
        SectionItem sectionItem = (SectionItem)i;
        holder2.txtTitle.setText(sectionItem.title); 
        break;
     }
    return row;
...

... int getViewType(...) {... return i.isSection()? 1:0;}

... int getViewTypeCount(){return 2;}