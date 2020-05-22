public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private Context context;
    List<Video_Details> video;

    public DataAdapter(List<Video_Details> video, Context context) {
        super();
        this.context = context;
        this.video = video;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Video_Details videoDetails =  video.get(position);
        String url;
        final String VideoID;

        holder.title.setText(video.get(position).getTitle());

        VideoID= video.get(position).getV_id();
        url = video.get(position).getThumb();

         Glide.with(context)
                 .load(url)
                 .override(150,70)
                 .into(holder.thumb);
       //viewHolder.thumb.setText(android.get(i).getVer());
      //  viewHolder.tv_api_level.setText(android.get(i).getApi());

        holder.vm.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             Toast.makeText(v.getContext(), "You Clicked"+video.get(position).getV_id(), Toast.LENGTH_SHORT).show();
                                             Intent intent = new Intent(v.getContext(),Play_Video.class);
                                             intent.putExtra("VideoId",(video.get(position).getV_id()));
                                             intent.putExtra("Title",(video.get(position).getTitle()));
                                             v.getContext().startActivity(intent);


                                         }
                                     }

        );
    }

    @Override
    public int getItemCount() {
        return video.size();
    }




    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView title;
        public ImageView thumb;
        public String videoid;
        public View vm;
        public ViewHolder(View view) {
            super(view);
            vm = view;
            title = (TextView)view.findViewById(R.id.title);
            thumb = (ImageView) view.findViewById(R.id.thumb);



            //tv_version = (TextView)view.findViewById(R.id.tv_version);
            //tv_api_level = (TextView)view.findViewById(R.id.tv_api_level);

        }
    }


}