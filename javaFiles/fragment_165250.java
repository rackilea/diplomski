public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemHolder> {

private List<Celebrity> celebrityList;
private final View.OnClickListener btnListener;

public ItemAdapter(List<Celebrity> celebrityList, View.OnClickListener btnListener) {
    this.celebrityList = celebrityList;
    this.btnListener = btnListener;
}

@Override
public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View itemView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_layout, parent, false);

    return new ItemHolder(itemView, btnListener);
}

@Override
public void onBindViewHolder(ItemHolder holder, int position) {
    Celebrity item = celebrityList.get(position);
    holder.txtCelebName.setText(item.getName());
    holder.txtCelebMovie.setText(item.getFamousMovie());
}

@Override
public int getItemCount() {
    return celebrityList.size();
}

public class ItemHolder extends RecyclerView.ViewHolder {


    private  Button buttoncalling;
    public TextView txtCelebName, txtCelebMovie;
    public ImageView profileImage;

    public ItemHolder(View view, View.OnClickListener btnListener) {
        super(view);
        txtCelebName = (TextView) view.findViewById(R.id.txtCelebName);
        txtCelebMovie = (TextView) view.findViewById(R.id.txtCelebMovie);
        profileImage = (ImageView) view.findViewById(R.id.profileImage);
        buttoncalling  = (Button) view.findViewById(R.id.buttonfordialog);
        buttoncalling.setOnClickListener(btnListener);
    }
}