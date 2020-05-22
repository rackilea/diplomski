public class BowlerAdapter extends RecyclerView.Adapter<BowlerAdapter.MyViewHolder> {

    private Context context;
    private List<Bowler> bowlersList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView bowlerLeagueId;
        public TextView name;
        public TextView timestamp;


        public MyViewHolder(View view) {
            super(view);
            bowlerLeagueId = view.findViewById(R.id.tvLeagueId);
            name = view.findViewById(R.id.tvBowlerName);
            timestamp = view.findViewById(R.id.timestamp);
        }
    }


    public BowlerAdapter(Context context, List<Bowler> bowlersList) {
        this.context = context;
        this.bowlersList = bowlersList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int fakeid = android.R.layout.simple_list_item_1;
        int realid = R.layout.listview_boweler;

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(realid, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Bowler bowler = bowlersList.get(position);

        holder.bowlerLeagueId.setText(bowler.getLeagueId());
        holder.name.setText(bowler.getName());

        //Formatting And Displaying Timestamp
        holder.timestamp.setText(formatDate(bowler.getTimestamp()));
    }

    @Override
    public int getItemCount() {
        return bowlersList.size();
    }

    //<<<<<<<<<< Added >>>>>>>>>>
    // This will get the actual bowler from the list
    public Bowler getItemAtPosition(int position) {
        return bowlersList.get(position);
    }

    //Formatting TimeStamp to 'EEE MMM dd yyyy (HH:mm:ss)'
    //Input  : 2018-05-23 9:59:01
    //Output : Wed May 23 2018 (9:59:01)
    private String formatDate(String dateStr) {
        try {
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = fmt.parse(dateStr);
            SimpleDateFormat fmtOut = new SimpleDateFormat("EEE MMM dd yyyy (HH:mm:ss)");
            return fmtOut.format(date);
        } catch (ParseException e) {
        }
        return "";
    }

    public void notifyDatasetChanged(List<Bowler> newbowlerlist) {
        bowlersList.clear();
        bowlersList.addAll(newbowlerlist);
        super.notifyDataSetChanged();
    }
}