//...
    private OnImageClickListener onImageClickListener;

    public VideoAdapter(ArrayList<Video> data, ArrayList<Video> data2, Activity activity, OnImageClickListener onImageClickListener) {
        this.mData = data;
        this.mData2 = data2;
        this.mACtivity = activity;
        this.onImageClickListener = onImageClickListener;
    }
    //...
    @Override
    public void onBindViewHolder(VideoHolder holder, int position) {
        //...
        holder.restaurantImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onImageClickListener.onImageClick(video2.getPic());
            }
        });
        //...
    }
    //...