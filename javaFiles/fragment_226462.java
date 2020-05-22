@Override
public int getItemViewType(final int position) 
  {
  return position==0?0:1;
  }

@Override
public View getView(final int position, final View convertView, final ViewGroup parent) 
  {
  int rowType=getItemViewType(position);
  if(rowType==0)
    {
    //handle a header (don't forget to use convertView)
    }
  else 
    {
    //handle a simple row (don't forget to use convertView and use the correct item)
    }
  }