public View getView(final int position, View convertView, ViewGroup parent)
    {
     ......

           holder.play.setBackgroundResource(R.drawable.play);
           if(checkposition!=-1)
          {
           holder.play.setBackgroundResource(R.drawable.played); 
           }


        return convertView;
    }