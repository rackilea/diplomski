public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ContentViewHolder> {

public  content[] mDataset;
private Activity activityContext;

public MyAdapter(Activity context,content[] data) {
    mDataset = data;
    activityContext = context;
}

@Override
public ContentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.test, parent, false);
    ContentViewHolder viewHolder = new ContentViewHolder(view);
    return viewHolder;
}

@Override
public void onBindViewHolder(ContentViewHolder holder, int position) {
    holder.bindContent(mDataset[position]);
}

@Override
public int getItemCount() {
    return mDataset.length;
}

public class ContentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView mUrl;
    public TextView mTitle;
    public TextView mDate;
    public TextView mAuthor;
    public ImageView mThumbnail;

    public ContentViewHolder(View itemView) {
        super(itemView);
        mUrl= (TextView) itemView.findViewById(R.id.url);
        mTitle = (TextView) itemView.findViewById(R.id.title);
        mDate = (TextView) itemView.findViewById(R.id.date);
        mAuthor = (TextView) itemView.findViewById(R.id.author);
        mThumbnail =(ImageView)itemView.findViewById(R.id.thumbnail);

    }

    public void bindContent(content bloginfo) {
        mUrl.setText(bloginfo.getUrl());
        mTitle.setText(bloginfo.getTitle());
        mDate.setText(bloginfo.getDate());
        mAuthor.setText(bloginfo.getAuthor());


        Picasso.with(activityContext).load(bloginfo.getThumbnail()).into(mThumbnail);

    }

    @Override
    public void onClick(View view) {

    }
  }
}