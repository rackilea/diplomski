{
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view= inflater.inflate(R.layout.vendor_custom_list,null);

        holder= new ViewHolder();
        holder.textViewName = (TextView)view.findViewById(R.id.cameraManName);
        holder.imageViewCamera=(ImageView)view.findViewById(R.id.cameraManImageView);
        holder.ratingBarCamera = (RatingBar)view.findViewById(R.id.cameraManRatingBar);
        holder.cameraManID = (TextView) view.findViewById(R.id.cameraManID);
        view.setTag(holder);

        return view;
    }