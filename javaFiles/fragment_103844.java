if ( convertView == null ) {
        convertView = mInflater.inflate( R.layout.list_item , null );
        holder = new ViewHolder();

     // here you should only initialise(findViewById) all your views 
     // remember don't set any values to your TextView/ImageViews here

      convertView.setTag( holder );

    } else {
        holder = ( ViewHolder ) convertView.getTag();
   }

 // here you should set value of your TextViews and ImageViews and your clickListeners