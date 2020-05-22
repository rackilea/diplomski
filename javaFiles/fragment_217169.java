View view = null;

    if (convertView == null) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = li.inflate(R.layout.listelement, null);

        final ViewHolder holder = new ViewHolder();
        holder.txtName = (TextView) view.findViewById(R.id.txtSongName);
        holder.btnFavorite = (ImageView) view.findViewById(R.id.btnFavorite);
        holder.btnPlayPause = (ImageView) view.findViewById(R.id.btnPlayPause);
        Typeface myTypeface =  Typeface.createFromAsset(context.getAssets(),         "fonts/Xcelsion.ttf"); 
        holder.txtName.setTypeface(myTypeface);
        view.setTag(holder);
    } else {
        view = convertView;
        // holder = (ViewHolder) view.getTag();
    }