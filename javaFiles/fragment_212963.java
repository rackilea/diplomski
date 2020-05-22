public class CustomAdapter extends BaseAdapter
{
    LayoutInfalter mInflater; 
    ArrayList<CommentsLibrary> list;  
    public CustomAdapter(Context context,ArrayList<CommentsLibrary> list)
    {
     mInflater = LayoutInfalter.from(context);
     this.list = list;  
    } 
    @Override
public int getCount() {
    // TODO Auto-generated method stub
    return list.size();
}

@Override
public Object getItem(int position) {
    // TODO Auto-generated method stub
    return position;
}

@Override
public long getItemId(int position) {
    // TODO Auto-generated method stub
    return position;
}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
    // TODO Auto-generated method stub
    ViewHolder holder;
    if(convertView==null)
    {
        convertView =minflater.inflate(R.layout.list_item, parent,false);
        holder = new ViewHolder();
        holder.tv1 = (TextView) convertView.findViewById(R.id.textView1);
        holder.tv2 = (TextView) convertView.findViewById(R.id.textView2);
        holder.tv3 = (TextView) convertView.findViewById(R.id.textView3); 
        convertView.setTag(holder);
    }
    else
    {
        holder= (ViewHolder) convertView.getTag();
    }
    holder.tv1.setText(list.get(position).getName());
            holder.tv2.setText(list.get(position).getContent());
            holder.tv3.setText(list.get(position).getPublished());
    return convertView;
}
static class ViewHolder
{
    TextView tv1,tv2,tv3

}
}