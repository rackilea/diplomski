public class NavigationAdapter extends RecyclerView.Adapter<NavigationAdapter.ViewHolder> {

    Context context;
    ArrayList<NavigationDataModel> arrayList = new ArrayList<>();

    public NavigationAdapter(Context context, ArrayList<NavigationDataModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.navIcon.setImageResource(arrayList.get(position).getIcon());
        holder.rootView.setBackgroundColor(arrayList.get(position).getColor());
        holder.navTitle.setText(arrayList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView navIcon;
        TextView navTitle;
        LinearLayout rootView;

        public ViewHolder(View itemView) {
            super(itemView);
            rootView = itemView.findViewById(R.id.rootView);
            navIcon = itemView.findViewById(R.id.navIcon);
            navTitle = itemView.findViewById(R.id.navTitle);
        }
    }
}