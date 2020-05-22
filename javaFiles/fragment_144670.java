public class DataAdapter  extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private Context context;
    ArrayList<Bookmark> arrayList = new ArrayList<>();

    public DataAdapter(Context context, ArrayList<Bookmark> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view=LayoutInflater.from(context).inflate(R.layout.custom_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.tvName.setText(arrayList.get(position).getName());

        holder.tvIcon.setImageResource(arrayList.get(position).getIcon());

        holder.tvId.setText(arrayList.get(position).getId());
        holder.tvSearchUrl.setText(arrayList.get(position).getSearchUrl());
        holder.tvNativeUrl.setText(arrayList.get(position).getNativeUrl());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvName,tvId,tvSearchUrl,tvNativeUrl;

        ImageView tvIcon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName=itemView.findViewById(R.id.tvName);
            tvIcon=itemView.findViewById(R.id.tvIcon);
            tvId=itemView.findViewById(R.id.tvId);
            tvSearchUrl=itemView.findViewById(R.id.tvSearchUrl);
            tvNativeUrl=itemView.findViewById(R.id.tvNativeUrl);
        }
    }
}