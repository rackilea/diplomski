// compile 'io.realm:android-adapters:2.0.0'
public class AdapterItemsRecycler
        extends RealmRecyclerViewAdapter<Item, ItemViewHolder> {
    private View.OnClickListener listener;

    public AdapterItemsRecycler(OrderedRealmCollection<Item> itemList, View.OnClickListener listener) {
        super(itemList, true);
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.my_list_detail, parent, false);
        view.setOnClickListener(listener);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Item item = getData().get(position);
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        itemViewHolder.loadItem(item);
    }

    private static class ItemViewHolder
            extends RecyclerView.ViewHolder {
        private TextView itemText;
        private ImageButton imageButton;

        public ItemViewHolder(View view) {
            super(view);
            itemText = (TextView) view.findViewById(R.id.textViewItemNameTD);
            imageButton = (ImageButton) view.findViewById(R.id.delete);
        }

        public void loadItem(Item item) {
            itemText.setText(item.getName());
            imageButton.setImageResource(R.drawable.trash);
        }

        public ImageButton getImageButton() {
            return imageButton;
        }
    }
}