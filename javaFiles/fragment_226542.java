public class Item {

    private int id;
    private ItemListAdapter.ClickListener mClickListener;

    public Item(int id) {
        this.id = id;
    }


    public Item(int id, @NonNull ItemListAdapter.ClickListener clickListener) {
        this.id = id;
        this.mClickListener = clickListener;
    }


    public Item setOnClickListener(@NonNull ItemListAdapter.ClickListener clickListener) {
        this.mClickListener = clickListener;
        return this;
    }


    public ItemListAdapter.ClickListener getClickListener() {
        return this.mClickListener;
    }

}