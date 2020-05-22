public class RecViewHolder extends RecyclerView.ViewHolder {

public TextView menuTeXT;

public RecViewHolder(View itemView){
    super(itemView);

    menuTeXT = (TextView)itemView.findViewById(R.id.menuTXT);
}
}