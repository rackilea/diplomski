@Override
public View getView(int position,View convertView,ViewGroup parent)
{
    View row=convertView;
    ViewHolder holder;

    if(row==null)
    {
        row=inflater.inflate(layout, null, false);
        holder=new ViewHolder(row);
        row.setTag(holder);
        holder.check_del.setTag(position);
    }
    else
    {
        holder=(ViewHolder)row.getTag();
        holder.check_del.setOnClickListener(null);
        holder.check_del.setTag(position);
        if(hitList.get(position))
            holder.check_del.setChecked(true);
        else
            holder.check_del.setChecked(false);
    }
    c.moveToPosition(position);
    holder.txt_a.setText(c.getString(c.getColumnIndex(ItemDB.TITLE)));
    holder.txt_b.setText(c.getString(c.getColumnIndex(ItemDB.DESCRIPTION)));

    OnClickListener cbl=new OnClickListener(){

        @Override
        public void onClick(View view) {
            // TODO Auto-generated method stub
            int position=(Integer)view.getTag();
            Log.d("CustomCursorAdapter", "The checkbox at postion "+position+" has been clicked");
            if(((CheckBox)view).isChecked())
            {
                hitList.set(position, true);
            }
            else 
            {
                hitList.set(position, false);
            }
        }
    };  

    holder.check_del.setOnClickListener(cbl);
    return row;
}

static class ViewHolder
{
    TextView txt_a;
    TextView txt_b;
    CheckBox check_del;
    ViewHolder(View row)
    {
        txt_a=(TextView)row.findViewById(R.id.txt_a);
        txt_b=(TextView)row.findViewById(R.id.txt_b);
        check_del=(CheckBox)row.findViewById(R.id.check_del);
    }
}