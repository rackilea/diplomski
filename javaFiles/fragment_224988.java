private Context mContext;
public MainScreenRecyclerAdapter (Context context) {
    mContext = context;
}


@Override 
    public void onBindViewHolder(ViewHolder holder, int position) {    
        String imageUrl = dataset.get(position);
        Timber.d("Image URL: " + imageUrl);

        ImageView view = holder.imageView;

        Picasso.with(MainActivity.context).load(imageUrl).into(view);
    }