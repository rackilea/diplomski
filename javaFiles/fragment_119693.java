public MyCustomListAdapter(Context context,int resource, ArrayList<Item> items)
    {
        super(context,resource,list);
        this.context= context;
        this.resource=resource;
        this.list=list;
    }