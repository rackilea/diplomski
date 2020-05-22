public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context mContext;
    private String[] mDataSet;
    private MediaPlayer mMediaPlayer;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextView;
        private OnMediaPlayRequestedListener mOnMediaPlayRequestedListener;

        public MyViewHolder(TextView v, OnMediaPlayRequestedListener listener) {
            super(v);

            mTextView = v;
            mTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnMediaPlayRequestedListener != null) {
                        mOnMediaPlayRequestedListener.onMediaPlayRequested(R.raw.{resource name});
                    }
                }
            });

            mOnMediaPlayRequestedListener = listener;
        }

        private interface OnMediaPlayRequestedListener {
            void onMediaPlayRequested(int resourceId);
        }
    }

    public MyAdapter(Context context, String[] myDataset) {
        mContext = context;
        mDataSet = myDataset;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TextView view =
                (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.my_text_view, parent, false);

        MyViewHolder holder = new MyViewHolder(
                view,
                new MyViewHolder.OnMediaPlayRequestedListener() {
                    @Override
                    public void onMediaPlayRequested(int resourceId) {
                        if (mMediaPlayer != null) {
                            mMediaPlayer.stop();
                            mMediaPlayer.release();
                        }

                        mMediaPlayer = MediaPlayer.create(mContext, resourceId);
                        mMediaPlayer.start();
                        mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                mediaPlayer.release();
                            }
                        });
                    }
                });


        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int position) {
        viewHolder.mTextView.setText(mDataSet[position]);
    }

    @Override
    public int getItemCount() {
        return mDataSet.length;
    }
}