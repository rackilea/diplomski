@Override
public void onBindViewHolder(@NonNull final MyViewHolder holder,  final int position) {

    holder.image.setImageResource(mdata.get(position).getImage());
    holder.image.setBorderColor(getColor(mContext, R.color.colorPrimary));

    holder.image.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            holder.image.setBorderColor(getColor(mContext, R.color.colorAccent));

            for (int i=0; i <= mdata.size(); i++){
                if (i != position){
                    notifyItemChanged(i, null);
                }

            }
        }
    });

}