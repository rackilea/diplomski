public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<ListItem> android_versions;
    private List<ListItem> listItems;
    private LayoutInflater layoutInflater;
    private Animation animationUp, animationDown;
    private Context context;
    private final int COUNTDOWN_RUNNING_TIME = 300;

    public DataAdapter(Context context, java.util.List<ListItem> android_versions,
                       Animation animationUp, Animation animationDown) {
        this.context = context;
        this.listItems = android_versions;
        this.animationDown = animationDown;
        this.animationUp = animationUp;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    public String getRandomColor(int a){
        String colors[] = {"#ef5350","#f44336","#ef5350"};
        return colors[a];
    }

    private void changeStateOfItemsInLayout(ListItem listItem, int p) {
        for (int x = 0; x < listItems.size(); x++) {
            if (x == p) {
                listItem.setShouldBeExpanded(true);
                //Since this is the tapped item, we will skip
                //the rest of loop for this item and set it expanded
                continue;
            }
            listItems.get(x).setShouldBeExpanded(false);
        }
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, int i) {
        ListItem listItem = listItems.get(i);
        if (i%2==2)
            holder.itemView.setBackgroundColor(Color.parseColor(getRandomColor(0)));
        else if (i%2==1)
            holder.itemView.setBackgroundColor(Color.parseColor(getRandomColor(1)));
        else if (i%2==0)
            holder.itemView.setBackgroundColor(Color.parseColor(getRandomColor(2)));

        holder.tv_android.setText(listItem.getSubName());
        holder.contentLayout.setText(listItem.getContent());
        if(listItem.getShouldBeExpanded()){
            holder.contentLayout.setVisibility(View.VISIBLE);
            holder.contentLayout.startAnimation(animationDown);
        }else{
            holder.contentLayout.startAnimation(animationUp);
            CountDownTimer countDownTimerStatic = new CountDownTimer(COUNTDOWN_RUNNING_TIME, 16) {
                @Override
                public void onTick(long millisUntilFinished) {}
                @Override
                public void onFinish() {
                    holder.contentLayout.setVisibility(View.GONE);
                }
            };
            countDownTimerStatic.start();
        }

        holder.expandit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.contentLayout.isShown()) {
                    listItems.get(holder.getLayoutPosition()).setShouldBeExpanded(false);
                } else {
                    listItems.get(holder.getLayoutPosition()).setShouldBeExpanded(true);
                    changeStateOfItemsInLayout(listItems.get(holder.getLayoutPosition()),holder.getLayoutPosition());
                }
                notifyDataSetChanged();
            }
        });
    }
    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_android;
        private TextView contentLayout;
        RelativeLayout expandit;
        public ViewHolder(View view) {
            super(view);
            tv_android = (TextView)view.findViewById(R.id.tv_android);
            contentLayout = (TextView) view.findViewById(R.id.content);
            expandit = (RelativeLayout)view.findViewById(R.id.expandit);
        }
    }
}