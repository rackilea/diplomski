public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Context context;
    ArrayList<String> list = new ArrayList<>();

    public CustomAdapter(Context context, ArrayList<String> list) { // you can pass other parameters in constructor
        this.context = context;
        this.list = list;
    }

    private class CustomAdapterItemView extends RecyclerView.ViewHolder {
        final TextView textView;

        CustomAdapterItemView(final View itemView) {
            super(itemView);
            textView = (TextView) itemView;
        }

        void bind(int position) {
            textView.setText("");
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CustomAdapterItemView(LayoutInflater.from(context).inflate(R.layout.item_color, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((CustomAdapterItemView) holder).bind(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    // Add your other methods here
}