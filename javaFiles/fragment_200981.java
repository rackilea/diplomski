Context context;
ArrayList<Category> categories;
ItemClickListener itemClickListener;

public CategoriesAdapter(Context context, ArrayList<Category> categories, ItemClickListener itemClickListener) {
    this.context = context;
    this.categories = categories;
    this.itemClickListener = itemClickListener;
}

// DON'T PASS YOUR DATA HERE, just create a ViewHolder
@Override
public CategoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.categorylist_singlecell, parent, false);
    CategoryHolder holder = new CategoryHolder(v, context);
    return holder;
}

//HERE you bind one item of your list to the view holder
@Override
public void onBindViewHolder(final CategoryHolder vh, final int i) {
    final Category category = categories.get(i);

    // set click listener
    vh.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            itemClickListener.onItemClicked(vh, category, i);
        }
    });

   // update images and texts...
}