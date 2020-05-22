private final Context context;
private ArrayList<Store> arrayStore;

public StoreAdapter(Context context, ArrayList<Store> arrayStore) {
    this.context = context;
    this.arrayStore = arrayStore;
}

@NonNull
@Override
public StoreAdapter.GameViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    return new StoreAdapter.GameViewHolder(LayoutInflater.from(context).inflate(
            R.layout.store_gridview, viewGroup, false));
}

@Override
public void onBindViewHolder(@NonNull final StoreAdapter.GameViewHolder viewHolder, final int position) {

    setColor(viewHolder);

    viewHolder.itemName.setText(arrayStore.get(position).getName());

    Glide.with(viewHolder.view.getContext())
            .load(arrayStore.get(position).getImage())
            .thumbnail(0.75f)
            .into(viewHolder.itemImage);

    viewHolder.view.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            sendData(viewHolder, position);
        }
    });
}

@Override
public int getItemCount() {
    return arrayStore.size();
}

class GameViewHolder extends RecyclerView.ViewHolder {

    private final View view;

    private final ImageView itemImage, itemRarity;
    private final TextView itemName;

    GameViewHolder(@NonNull View itemView) {
        super(itemView);
        this.view = itemView;

        itemRarity = view.findViewById(R.id.itemRarity);
        itemImage = view.findViewById(R.id.itemImage);

        itemName = view.findViewById(R.id.itemName);

    }
}

private void sendData(@NonNull final StoreAdapter.GameViewHolder viewHolder, int position) {
    if (viewHolder.getAdapterPosition() != RecyclerView.NO_POSITION) {

        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra("name", arrayStore.get(position).getName());
        intent.putExtra("rarity", arrayStore.get(position).getRarity());
        intent.putExtra("item", arrayStore.get(position).getImage());
        intent.putExtra("price", arrayStore.get(position).getPrice());
        intent.putExtra("key", "Store");
        context.startActivity(intent);
    }
}

private void setColor(@NonNull final StoreAdapter.GameViewHolder viewHolder) {
    String rarity = arrayStore.get(viewHolder.getAdapterPosition()).getRarity();

    if (rarity.contains("legendary")) {
        viewHolder.itemRarity.setImageResource(R.drawable.color_legendary_gradient);
    } else if (rarity.contains("classic")) {
        viewHolder.itemRarity.setImageResource(R.drawable.color_classic_gradient);
    } else if (rarity.contains("epic")) {
        viewHolder.itemRarity.setImageResource(R.drawable.color_epic_gradient);
    } else if (rarity.contains("elite")) {
        viewHolder.itemRarity.setImageResource(R.drawable.color_elite_gradient);
    } else if (rarity.contains("rare")) {
        viewHolder.itemRarity.setImageResource(R.drawable.color_rare_gradient);
    } else if (rarity.contains("special")) {
        viewHolder.itemRarity.setImageResource(R.drawable.color_special_gradient);
    }
}