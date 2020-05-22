// BaseSearchAdapter is the class that contains the 'List<T> mItems' member variable
public class SearchAdapter<T> extends BaseSearchAdapter<SearchAdapter.ViewHolder<T>, T> {

    private Context mContext;
    private ViewHolderBinder<T> mBinder;

    public SearchAdapter(Context context, List<T> items, ViewHolderBinder<T> binder) {
        mContext = context;
        mItems = new ArrayList<>(items);
        mBinder = binder;
    }

    @Override
    public void onBindViewHolder(ViewHolder<T> holder, int position) {
        T item = mItems.get(position);
        holder.bind(item);
    }

    public static class ViewHolder<T> extends RecyclerView.ViewHolder {
        ViewHolderBinder<T> mBinder;

        TextView textLabel;


        public ViewHolder(View v, ViewHolderBinder<T> binder) {
            textLabel = (TextView)v.findViewById(R.id.text_label);
            this.mBinder = binder;
        }

        public void bind(T item) {
            binder.bind(this, item);
        }
    }

    public interface ViewHolderBinder<T> {
        void bind(ViewHolder<T> viewHolder, T item);
    }

    public static class StringViewHolderBinder implements ViewHolderBinder<String> {
        @Override
        public void bind(ViewHolder<String> viewHolder, String item) {
             viewHolder.textLabel.setText(item);
        }
    }

    public static class ProductViewHolderBinder implements ViewHolderBinder<Product> {
        @Override
        public void bind(ViewHolder<Product> viewHolder, Product item) {
             viewHolder.textLabel.setText(item.getName());
        }
    }
}