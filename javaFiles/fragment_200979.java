public interface ItemClickListener {

    void onItemClicked(ViewHolder vh, Object item, int pos);
}

public interface GenericItemClickListener<T, VH extends ViewHolder> {

    void onItemClicked(VH vh, T item, int pos);
}