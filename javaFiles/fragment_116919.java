class CustomAdapter extends ArrayAdapter<GS>
  {
       ArrayList<GS> list;
       LayoutInfalter mInfalter;    
       public CustomAdapter(Context context, ArrayList<GS> list)
       {
          super(context,R.layout.customlayout,list);
          this.list= list  
          mInfalter = LayoutInfalter.from(context);
       }   
        public View getView(int position, View convertView, ViewGroup parent) {
          ViewHolder holder;
          if(convertView==null)
          {
               convertView = mInflater.inflate(R.layout.customlayout,parent,false);
               holder = new ViewHolder();
               holder.tv1 = (TextView)convertView.findViewById(R.id.textView1); 
               convertView.setTag(holder); 
          }else{
                holder = (ViewHolder)convertVire.getTag();
          } 

                holder.tv1.setText(list.get(postion).getAS_name());
          return convertVIew;
    }
    static class ViewHolder
    {
        TextView tv1;
    }    
  }