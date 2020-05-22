public interface OnItemClickListener {
        void onItemClick(View v);
    }

    private final OnItemClickListener listener;

    public RecAdapter(OnItemClickListener listener) {
        this.listener = listener;
    }

    public ViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemCLick(v);
            }
        });
    }