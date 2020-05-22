public View getView(int position, View convertView, ViewGroup parent){

    ViewHolder vh;
    if(convertView==null)
    {
      vh = new ViewHolder();
      convertView = inflater.inflate(
                R.layout.drawer_list_item, parent, false);  
      vh.txtTitle = (TextView) convertView.findViewById(R.id.title);
      vh.txtSubtitle = (TextView) convertView.findViewById(R.id.subtitle);
      vh.imgIcon = (ImageView) convertView.findViewById(R.id.icon); 

        convertView.setTag(vh); 
    } else { 
    vh = (ViewHolder) convertView.getTag(); 
    } 
    vh.txtTitle.setText(titles[position]);
    vh.txtSubtitle.setText(subtitles[position]);
    vh.imgIcon.setImageResource(icons[position]);

    return convertView;
    }
static class ViewHolder
{
TextView txtTitle,txtSubtitle;
ImageView imgIcon;
}