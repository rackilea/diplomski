public class ShowAppAdapter extends RecyclerView.Adapter<ShowAppAdapter.ShowAppAdapterViewHolder> {

  private List<String> appProcessInfos;

    public ShowAppAdapter(List<String> appProcessInfos){
        this.appProcessInfos = appProcessInfos;

    }

    @NonNull
    @Override
    public ShowAppAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.appshow_layout, parent,false);
        return new ShowAppAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShowAppAdapterViewHolder holder, int position) {
        String title = appProcessInfos.get(position);

        holder.textView.setText(title);


    }

    @Override
    public int getItemCount() {
        return appProcessInfos.size();
    }

    public class ShowAppAdapterViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;
        public ShowAppAdapterViewHolder(View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.imageView);

        }
    }



}