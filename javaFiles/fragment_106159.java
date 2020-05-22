public ProduitsAdapter(Context ctx, int textViewResourceId, List<StackProduits> sites) {
super(ctx, textViewResourceId, sites);
productList = sites;

//Setup the ImageLoader, we'll use this to display our images
ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(ctx).build();
imageLoader = ImageLoader.getInstance();
imageLoader.init(config);

mSelectedItemsIds = new SparseBooleanArray();

//Setup options for ImageLoader so it will handle caching for us.
options = new DisplayImageOptions.Builder()
        .cacheInMemory()
        .cacheOnDisc()
        .build();
}