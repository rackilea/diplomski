public View getView(int position, View view, ViewGroup parent) {
 ViewHolder viewHolder;
 if(view == null) {
   viewHolder = new ViewHolder();
   LayoutInflater inflater=context.getLayoutInflater();
   View rowView=inflater.inflate(R.layout.emp_leave_adpater_layout, null,true);

  viewHolder.txtTitle = (TextView) rowView.findViewById(R.id.item);
  viewHolder.image=(ImageView)rowView.findViewById(R.id.icon);
  view.setTag(viewHolder);
    } else {
      viewHolder = (ViewHolder) view.getTag();
    }   
  viewHolder.txtTitle.setText(itemname[position]);

  return viewHolder;
};


public class viewholder {

 public TextView txtTitle;
 public ImageView image;
}