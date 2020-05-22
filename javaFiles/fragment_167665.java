public BackgroundTask(Context ctx, RecyclerView.Adapter adapter, ArrayList<Request> arrayList){
    this.ctx = ctx;
    this.adapter = adapter;
    this.arrayList = arrayList;
    activity = (Activity) ctx;
}