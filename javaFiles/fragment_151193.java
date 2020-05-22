public class MenuRecAdapter extends RecyclerView.Adapter<RecViewHolder>{

private ArrayList<String> mList = new ArrayList<>();
Activity context;

public MenuRecAdapter(ArrayList<String> mList){
    this.mList = mList;
}

public int getItemCount(){
    return mList.size();
}

public RecViewHolder onCreateViewHolder(ViewGroup viewGroup, int position){

    View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.menuitem, viewGroup, false);
    RecViewHolder pvh = new RecViewHolder(v);
    return pvh;
}

public void onBindViewHolder(RecViewHolder holder, int i){
    holder.menuTeXT.setText(mList.get(i));
}

@Override
public void onAttachedToRecyclerView(RecyclerView recyclerView) {
    super.onAttachedToRecyclerView(recyclerView);
}
}