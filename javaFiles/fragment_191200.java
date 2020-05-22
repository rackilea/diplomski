public class FlowerListAdapter extends RecyclerView.Adapter<FlowerListAdapter.MyViewHolder>   {

    ArrayList<FlowerListPojo> list;
    Context context;
    ClickPosition clickPosition;

    public FlowerListAdapter(Context context, ArrayList<FlowerListPojo> list) {
        this.context = context;
        this.list = list;
    }

    //Pagination
    public void updateList(ArrayList<FlowerListPojo> list) {
        this.list.addAll(list);
        this.notifyDataSetChanged();
    }


    @Override
    public FlowerListAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.flower_list_row, viewGroup, false);
        return new FlowerListAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FlowerListAdapter.MyViewHolder holder, int position) {

        LinearLayoutManager mLayoutManager;

        holder.name.setText(list.get(position).getInfo().getName());
        ArrayList<CalenderPojo> listCal = new ArrayList<>();
        Glide.with(context).load(list.get(position).getInfo().getImage())
                .thumbnail(0.5f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imageFlower);

        mLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        holder.recyclerView.setLayoutManager(mLayoutManager);
        holder.recyclerView.setItemAnimator(new DefaultItemAnimator());

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //todays date
        Date cToday = Calendar.getInstance().getTime();
        String todaysDate = df.format(cToday);
        //last day last next 90 days
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 90);
        Date d = c.getTime();
        String lastDate = df.format(d);


        List<Date> dates = getDates(todaysDate, lastDate);
        for (Date date : dates) {

            String dayOfTheWeek = (String) DateFormat.format("EEE", date); // Thursday
            String day = (String) DateFormat.format("dd", date); // 20
            String monthString = (String) DateFormat.format("MMMM", date); // Jun
            String monthNumber = (String) DateFormat.format("MM", date); // 06
            String year = (String) DateFormat.format("yyyy", date); // 2013

            listCal.add(new CalenderPojo(dayOfTheWeek, day, "200", monthString + " " + year));
        }

        holder.recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                int firstVisiblePosition = mLayoutManager.findFirstVisibleItemPosition();
                if(firstVisiblePosition>=0)
                    holder.monthName.setText(listCal.get(firstVisiblePosition+3).getMonth());
            }
        });

        holder.recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



        //Date send to Adapter / Constructor call
        holder.adapter = new CalenderAdapter(context, listCal,clickPosition);
        holder.recyclerView.setAdapter(holder.adapter);
    }


    @Override
    public int getItemCount() {
        if (list.size() != 0)
            return list.size();
        else return 0;
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView imageFlower;
        RecyclerView recyclerView;
        TextView monthName;
        CalenderAdapter adapter;

        public MyViewHolder(View itemView) {
            super(itemView);

            clickPosition= new ClickPosition() {
                @Override
                public void getPosition(int position) {
                    Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show();
                }
            };
            name = itemView.findViewById(R.id.flowerNameFLR);
            imageFlower = itemView.findViewById(R.id.flowerImgFLR);
            recyclerView = itemView.findViewById(R.id.recycler_view_calender);
            monthName = itemView.findViewById(R.id.monthName);

        }



    }


    private static List<Date> getDates(String dateString1, String dateString2) {
        ArrayList<Date> dates = new ArrayList<Date>();
        java.text.DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");

        Date date1 = null;
        Date date2 = null;

        try {
            date1 = df1.parse(dateString1);
            date2 = df1.parse(dateString2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);


        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);

        while (!cal1.after(cal2)) {
            dates.add(cal1.getTime());
            cal1.add(Calendar.DATE, 1);
        }
        return dates;
    }

}