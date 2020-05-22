public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.Holder> {
//private String url[];
private Context context;
private AdView mBannerAd;
int AD_TYPE = 0;
private Activity mainActivity;
private LayoutInflater inflater;
int CONTENT_TYPE = 1;



public class ViewHolder extends RecyclerView.ViewHolder {
    public TextView mTextView;
    public ViewHolder(View v) {
        super(v);
        if (!(itemView instanceof AdView)) {
            mTextView = (TextView) v.findViewById(R.id.text);
        }
    }
}


public AdapterRecyclerView(Context context) {
    this.context = context;
    // this.url = list;


}




@NonNull
@Override
public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    AdView adview;
    ViewHolder holder;


    if (viewType == AD_TYPE) {
        adview = new AdView(mainActivity);
        adview.setAdSize( AdSize.BANNER);

        adview.setAdUnitId("ca-app-pub-3940256099942544/6300978111");

        float density = mainActivity.getResources().getDisplayMetrics().density;
        int height = Math.round(AdSize.BANNER.getHeight() * density);
        AbsListView.LayoutParams params = new AbsListView.LayoutParams(AbsListView.LayoutParams.FILL_PARENT, height);
        adview.setLayoutParams(params);


        AdRequest request = new AdRequest.Builder().build();
        adview.loadAd(request);
        return new Holder (adview);

    }else{
        View view = inflater.inflate(R.layout.recyclerview_row, parent, false);
        return new Holder( view);
    }





}



@Override
public void onBindViewHolder(@NonNull final Holder holder, final int position) {

    if(position % 2 != 1) {



        holder.titleView.setText(SplashScreen.newsList.get(position).getNewsTitle());
        holder.detailsView.setText(SplashScreen.newsList.get(position).getNewsDetail());
        Glide.with(context).load(SplashScreen.newsList.get(position).getNewsImageUrl()).into(holder.imgView);

        holder.hiddenUrl.setText(SplashScreen.newsList.get(position).getNewsUrl());

        holder.explore.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent myIntent = new Intent(v.getContext(), newsExplore.class);
            myIntent.putExtra("newsUrl", SplashScreen.newsList.get(position).getNewsUrl());
            v.getContext().startActivity(myIntent);
        }
    });


     holder.share.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent sharingIntent = new Intent( Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "This news is shared using News app :: " + "\n\n" + SplashScreen.newsList.get(position).getNewsUrl();
            sharingIntent.putExtra( Intent.EXTRA_SUBJECT, "Subject Here");
            sharingIntent.putExtra( Intent.EXTRA_TEXT, shareBody);
            v.getContext().startActivity( Intent.createChooser(sharingIntent, "Share via"));
        }
    });



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

    }
}