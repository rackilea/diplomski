public Adapter(@NonNull Context context, ArrayList<Item> items) {
        super(context, R.layout.listview_item);
        this.context = context;
        this.items = items;

    }