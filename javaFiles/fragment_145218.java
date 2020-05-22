public CustomAdapter(Context context, int custom_adapter, ArrayList<Model> mModel) {
    this.context = context;
    this.mModel = mModel;
    this.custom_adapter = custom_adapter;
    dba = new DatabaseHelper(context);
}