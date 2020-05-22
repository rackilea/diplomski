Custom Adapter.java

        class CustomViewHolder extends  RecyclerView.ViewHolder {

        RibbonLayout ribbonLayout;
        ImageView imageView;

        public CustomViewHolder(View itemView) {
            super(itemView);

            ribbonLayout = (RibbonLayout)itemView.findViewById(R.id.ribbonLayout);
            imageView = (ImageView)itemView.findViewById(R.id.imageView);
        }

        }

        public class CustomAdapter extends  RecyclerView.Adapter<CustomViewHolder> {

        Context context;

        List<Item> itemList;

        public CustomAdapter(Context context, List<Item> itemList) {
            this.context = context;
            this.itemList = itemList;
        }

        @Override
        public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
            return new CustomViewHolder(itemView);

        }

        @Override
        public void onBindViewHolder(CustomViewHolder holder, int position) {
            Item item = itemList.get(position);
            if (item.type == 0) { //new
                holder.ribbonLayout.setShowBottom(false);
                holder.ribbonLayout.setShowBottom(false);


                holder.ribbonLayout.setHeaderRibbonColor(Color.parseColor("#2B323A"));
                holder.ribbonLayout.setHeaderTextColor(Color.parseColor("#FFFFFF"));

                holder.ribbonLayout.setHeaderText((item.headerText));
                Picasso.with(context).load(item.imageURL)
                        .into(holder.imageView);
                holder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            Bitmap bitmap = ((BitmapDrawable) ((ImageView) view).getDrawable()).getBitmap();
                            WallpaperManager wallpaperManager = WallpaperManager.getInstance(context);
                            wallpaperManager.setBitmap(bitmap);

                            Toast.makeText(context, " \\ (•◡•) /Yay! Wallpaper Set \\ (•◡•) / ", Toast.LENGTH_LONG).show();
 Activity.ShowAd();//Hope you want to call the ads from here.
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }

        @Override
        public int getItemCount() {
            return itemList.size();
        }
    }