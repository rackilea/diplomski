public class AdsAdapter extends RecyclerView.Adapter<AdsAdapter.AdsViewHolder> {

private ArrayList<Ads> dataList;
Context _C1;
Activity _A1;
RecyclerView r;
int SelectedPos = 0;
int id_prev;
CardView CV_Prev = null;
private int mItemSelected=-1;

public AdsAdapter(ArrayList<Ads> dataList, FragmentActivity activity, Context _C, Activity _A, RecyclerView recyclerView, int i) {
    this.dataList = dataList;
    _A1 = _A;
    _C1 = _C;
    r = recyclerView;

}


@Override
public AdsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    final LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
    final View view = layoutInflater.inflate(R.layout.avatars, parent, false);
    return new AdsViewHolder(view);
}

@Override
public void onBindViewHolder(AdsViewHolder holder, int position) {

 holder.CV_item.setTag(position);
holder.img_avatar.setImageResource(dataList.get(position).getImage());
    if(mItemSelected==position){

     //code for image selected. 
        holder.CV_item.setVisibility(View.VISIBLE);

    }else{

    //code for image unselected. 
        holder.CV_item.setVisibility(View.INVISIBLE);

    }

}

@Override
public int getItemCount() {
    return dataList.size();
}


class AdsViewHolder extends RecyclerView.ViewHolder {

    ImageView img_avatar;
    CardView CV_item;
    AdsViewHolder(View itemView) {
        super(itemView);
        //-----------------------------------------------------------
        img_avatar = (ImageView) itemView.findViewById(R.id.img_avatar);
        CV_item = (CardView) itemView.findViewById(R.id.cardView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mItemSelected=getAdapterPosition();
                notifyDataSetChanged();
            }
        });

    }

  }
}