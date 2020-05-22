public class MyCardsAdapter extends RecyclerView.Adapter<MyCardsAdapter.ItemHolder> {

    private List<Item> itemsList;
    private Context context;

    public MyReposAdapter(List<Item> itemsList, Context context) {
        this.itemsList = itemsList;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item, parent, false);

        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {

        // Get each item.
        Item singleItem = itemsList.get(position);

        // singleItem is each Item.java you created. And holder contains the widgets you created in single_item.xml to display the items information.
        holder.textViewName.setText(singleItem.name);
        holder.textViewImage.setText(sigleItem.image_url);
        holder.textViewLink.setText(singleItem.link);

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


    public class ItemHolder extends RecyclerView.ViewHolder {

        public TextView textViewName;
        public TextView textViewImage;
        public TextView textViewLink;

        public ItemHolder(View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.text_name);
            textViewImage = itemView.findViewById(R.id.text_image);
            textViewLink = itemView.findViewById(R.id.text_link);

        }

    }

}