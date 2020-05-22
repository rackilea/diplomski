int color;
RecyclerViewAdapter recyclerViewAdapter =
                        new RecyclerViewAdapter(this, userList, color);

//////////////////////////////////////////////////////////////////////////

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder>{

private Context context;
public static List<UserList> userList;
private int color;

public UserAdapter(Context context, List<UserList> userList, int color){
    super();
    //Getting all the superheroes
    this.color = color;
    this.userList = userList;
    this.context = context;
}
 @Override
public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.list_layout, parent, false);

    ViewHolder viewHolder = new ViewHolder(v);
    return viewHolder;
}

@Override
public void onBindViewHolder(ViewHolder holder, final int position) {    
 holder.colorText.setText(mColorText.setText);
//here you will change the text color from mainactivity
   // this change color
    holder.colorText.setTextColor(ContextCompat.getColor(context,color));

}

@Override
public int getItemCount() {
    return 0;
}


public class ViewHolder extends RecyclerView.ViewHolder {

    public TextView colorText;


    public ViewHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();

    }

}