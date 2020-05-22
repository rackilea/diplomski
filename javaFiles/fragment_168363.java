public class SpecialAdapter extends RecyclerView.Adapter<SpecialAdapter.SpecialViewHolder> {

    private ArrayList<AppDetail> items;
    private Context context;
    private OnClickItem clickListener;

    public SpecialAdapter(ArrayList<AppDetail> items, Context context) {
        this.items = items;
        this.context = context;
    }

    public void setClickListener(OnClickItem clickListener) {
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public SpecialViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new SpecialViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SpecialViewHolder holder, int position) {
        holder.appIcon.setImageDrawable(items.get(position).icon);
        holder.appLabel.setText(items.get(position).label);
        holder.appName.setText(items.get(position).name);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class SpecialViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView appIcon;
        TextView appLabel;
        TextView appName;

        public SpecialViewHolder(View itemView) {
            super(itemView);
            appIcon = (ImageView) itemView.findViewById(R.id.item_app_icon);
            appLabel = (TextView) itemView.findViewById(R.id.item_app_label);
            appName = (TextView) itemView.findViewById(R.id.item_app_name);
             itemview.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickListener.onClickItem(getAdapterPosition());
        }
    }

    public interface OnClickItem {
        void onClickItem(int pos);
    }
}