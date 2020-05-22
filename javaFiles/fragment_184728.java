public class SampleActivity extends Activity{
    RecyclerView sampleRecycle;
    MyRecyclerAdapter myRecyclerAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_activity);

        sampleRecycle = (RecyclerView) findViewById(R.id.sampleRecycle);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        sampleRecycle.setLayoutManager(mLayoutManager);
        myRecyclerAdapter = new MyRecyclerAdapter(this);
        sampleRecycle.setAdapter(myRecyclerAdapter);
    }


    public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {
        private Context context;
//        private List<ForumsListItem> forumsListItems;
//        ForumsFragment fragment = new ForumsFragment();

        //Define the constructor for both contenxt and listItem
        public MyRecyclerAdapter(Context context) {
            this.context = context;
//            forumsListItems = items;

        }

        @NonNull
        @Override
        public MyRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_items, parent, false);

            return new MyViewHolder(v);
        }

        /*Bind everything from te MyViewHolder*/
        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            //Define listItem position
//            ForumsListItem listItem = forumsListItems.get(position);

            //Calling the textView inside bindingViewHolder
            //holder.catListName.setText(listItem.getCatlistName());
//            holder.numOfDailyNewPosts.setText(listItem.getNumOftodayPosts());
//            holder.descriptTv.setText(listItem.getDescription());
        }

        @Override
        public int getItemCount() {
            return 20;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            private TextView nameTv, descriptTv, numOfDailyNewPosts, catListName;

            private ImageView imgIcons;

            public MyViewHolder(View itemView) {
                super(itemView);
                //things to display in form of List

                descriptTv = (TextView) itemView.findViewById(R.id.item_detail);
//                catListName = (TextView) itemView.findViewById(R.id.catListTxt);
                numOfDailyNewPosts = (TextView) itemView.findViewById(R.id.numOfDailyNewPosts);
                //can add Picaso loding images here
                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                int pos = getAdapterPosition();
                //get the current position

//                ForumsListItem items = forumsListItems.get(pos);

//                Toast.makeText(context, items.getForumsTitles(), Toast.LENGTH_LONG).show();
                //On click functionality

            }
        }
    }
}