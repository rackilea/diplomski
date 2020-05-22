public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_1 = 1;
    private static final int TYPE_2 = 2;

    int randomPos = 0;

    public MyAdapter (Context context, List<MyItem> items){
        this.items = items;
        this.context = context;
        randomPos = new Random().nextInt(items.size());
    }
    @Override
    public int getItemViewType(int position) {
        return position == randomPos ? TYPE_2 : TYPE_1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
         switch (viewType) {
             case TYPE_1: return new ViewHolder1(...);
             case TYPE_2: return new ViewHolder2(...);
         }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        switch (holder.getItemViewType()) {
            case TYPE_1:
                ViewHolder1 viewHolder1 = (ViewHolder1)holder;
                ...
                break;
            case TYPE_2:
                ViewHolder2 viewHolder2 = (ViewHolder2)holder;
                ...
                break;
        }
    }

    class ViewHolder1 extends RecyclerView.ViewHolder {
        ...
        public ViewHolder1(View itemView){
        ...
        }
    }

    class ViewHolder2 extends RecyclerView.ViewHolder {
        ...
        public ViewHolder2(View itemView){
        ...
    }
}