@Override
   public View getView(int position, View convertView, ViewGroup parent) {
       View row = convertView;
       ImageHolder holder = null;

       if(row == null)
       {
           LayoutInflater inflater = ((Activity)context).getLayoutInflater();
           row = inflater.inflate(layoutResourceId, parent, false);

           holder = new ImageHolder();
           holder.txtTitle = (TextView)row.findViewById(R.id.tvDateVal);
           //holder.txtTitle.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/robm.ttf"));
           holder.imgIcon = (ImageView)row.findViewById(R.id.ivIcon0);
           holder.txtID = (TextView)row.findViewById(R.id.tvReasonVal);
           //holder.txtID.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "fonts/robm.ttf"));
           row.setTag(holder);
       }
       else
       {
           holder = (ImageHolder)row.getTag();
       }

       SetRows myImage = data.get(position);
       holder.txtTitle.setText(myImage.name);
       holder.txtID.setText(myImage.id);
       int outImage=myImage.image;
       if (data.getValue)
          holder.imgIcon.setImageResource(deferentIcon);
       else
          holder.imgIcon.setImageResource(defaultIcon);
      return row;

   }