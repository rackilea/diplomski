public class WorkerAdapter extends RecyclerView.Adapter<WorkerAdapter.ViewHolder>{
    Context context;
    List<Workers> list;

    public WorkerAdapter(Context context,List<Workers> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_recycler,parent,false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.id.setText(String.valueOf(list.get(position).getUserid()));
        holder.name.setText(list.get(position).getUsername());
        holder.job.setText(list.get(position).getJob());
        holder.age.setText(String.valueOf(list.get(position).getAge()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, job, age,id;

        public ViewHolder(View itemView) {
            super(itemView);
            id = (TextView) itemView.findViewById(R.id.idtxt);
            name= (TextView) itemView.findViewById(R.id.nametxt);
            job=(TextView) itemView.findViewById(R.id.jobtxt);
            age=(TextView) itemView.findViewById(R.id.agetxt);
        }
    }
}