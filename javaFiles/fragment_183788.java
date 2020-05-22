public class MyAdapter extends RecyclerView.Adapter {

     private String[] mDataset;


public MyAdapter(String[] myDataset){
mDataset = myDataset;
}

 @Override
 public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
    View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
    MyViewHolder vh = new MyViewHolder(v);
    return vh;
}

@Override
public void onBindViewHolder(MyViewHolder holder, int position){
    holder.mTextView.setText(mDataset[position]);
    holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.bindCliks(groupItem);
            }
        });

@Override 
public int getItemCount() { return mDataset.length; }
}



public static class MyViewHolder extends RecyclerView.ViewHolder{
     public CardView mCardView;
     public TextView mTextView;

     public MyViewHolder(View v){
          super(v);

          mCardView = (CardView) v.findViewById(R.id.card_view);
          mTextView = (TextView) v.findViewById(R.id.tv_text);
     }


    public void bindCliks(int position) {
        Intent intent = new Intent(context, 
            OtherActivity.class);
       //use number here to get your string item and use it to other activity.
        context.startActivity(intent);
    }
}