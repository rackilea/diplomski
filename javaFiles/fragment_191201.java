public class CalenderAdapter extends RecyclerView.Adapter<CalenderAdapter.MyViewHolder> {
    ArrayList<CalenderPojo> list;
    Context context;
    private int mSelectedItem = -1;
    ClickPosition clickPosition;

    public CalenderAdapter(Context context, ArrayList<CalenderPojo> listCal, ClickPosition clickPosition) {
        this.context = context;
        this.list = listCal;
        this.clickPosition = clickPosition;
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.date_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final CalenderPojo listPotn = list.get(position);

        holder.day.setText(listPotn.getDay());
        holder.date.setText(listPotn.getDate());
        holder.price.setText("$ "+listPotn.getPrice());


        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSelectedItem = position;
                notifyDataSetChanged();
                clickPosition.getPosition(position);
                };
                // ((FlowerListAdapter)context).sendTimedetails(position);
            }
        });
        if (mSelectedItem==position) {
            holder.itemView.setBackgroundResource(R.drawable.selected_date_back);
            holder.day.setTextColor(context.getResources().getColor(R.color.white));
            holder.date.setTextColor(context.getResources().getColor(R.color.white));
            holder.price.setTextColor(context.getResources().getColor(R.color.white));
        } else {
            holder.linearLayout.setBackgroundColor(context.getResources().getColor(R.color.primaryLight2));
            holder.day.setTextColor(context.getResources().getColor(R.color.black));
            holder.date.setTextColor(context.getResources().getColor(R.color.black));
            holder.price.setTextColor(context.getResources().getColor(R.color.black));
        }

    }

    @Override
    public int getItemCount() {
        if (list.size() != 0 && list !=null)
            return list.size();
        else return 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView day, date, price;
        LinearLayout linearLayout;

        public MyViewHolder(View itemView) {
            super(itemView);
            day = itemView.findViewById(R.id.day);
            date = itemView.findViewById(R.id.date);
            price = itemView.findViewById(R.id.price);
            linearLayout = itemView.findViewById(R.id.lLayout);
        }
    }
}