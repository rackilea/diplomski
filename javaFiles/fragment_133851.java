@Override
public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    RecyclerView.ViewHolder holder = null;
    if(viewType == POST_VIEW_TYPE){
        View view = LayoutInflater.from(App.instance).inflate(R.layout.item_post, parent, false);
        holder = new PostViewHolder(view);
    }else{
        View view = LayoutInflater.from(App.instance).inflate(R.layout.item_user, parent, false);
        holder = new UserViewHolder(view);
    }
    return holder;
}