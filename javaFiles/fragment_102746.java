public class FeaturedlistAdapter extends RecyclerView.Adapter<FeaturedlistAdapter.FeaturedView>
{
    private Context context;
    private List<Featured_data> featuredData;
    private SparseBooleanArray mSelectedFlags;

    public FeaturedlistAdapter(Context context, List<Featured_data> featured_data,MyAdapterListener  myAdapterListener) {
        ...

        // init the flag
        mSparseBooleanArray = new SparseBooleanArray();

    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedView featuredView, int i) {
       int position = featuredView.getAdapterPosition();
       Featured_data data = featuredData.get(position);

       // reset the state of the view each time the 
       // view get recycled by applying the flag.
       if(mSelectedFlags.get(position)) {
          // set the selected state, i.e red
       } else {
          // SparseBooleanArray.get(i) is false if not found
          // set the unselected state, i.e grey
       }
}