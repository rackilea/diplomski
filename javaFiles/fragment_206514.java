@Override
public View getView(int position, View convertView, ViewGroup parent)
{
    ViewHolder holder = null;
    if(convertView == null || ((ViewHolder)convertView.getTag()).id != this.items.get(position).getId())
    {
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(this.items.get(position).getId() == this.id)
            convertView = layoutInflater.inflate(R.layout.layout1);
        else
            convertView = layoutInflater.inflate(R.layout.layout2);
        holder = new ViewHolder();
        holder.textView1 = (TextView) convertView.findViewById(R.id.textViewItem1);
        holder.textView2 = (TextView) convertView.findViewById(R.id.textViewItem2);
        holder.id = this.items.get(position).getId();
        convertView.setTag(holder);
    }
    else
    {
        holder = (ViewHolder) convertView.getTag();
    }
    holder.textView1.setText(this.items.get(position).getInfo1());
    holder.textView2.setText(this.items.get(position).getInfo2());
    return convertView;
}

public static class ViewHolder
{
    public int id; //Assuming your id is an int, if not, changed it to the correct type
    public TextView textView1;
    public TextView textView2;
}