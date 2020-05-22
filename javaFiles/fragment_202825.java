Context context;
    int rank;
    int[] flag;
    LayoutInflater inflater;

    public ListViewAdapter(Context context, int layout, Cursor cursor, String[] from, int[] to, int rank) {
        super(context, layout , cursor, from, to);
        this.rank = rank;
        this.context = context; //missing
    }