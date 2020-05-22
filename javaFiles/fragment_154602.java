@Override
public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
    holder.ivMainInterest.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            boolean selection = mainInterestModel.isSelected();
            if (selection) {
                holder.ivMainInterest.setImageResource(R.drawable.ic_bath);
                mainInterestModel.setSelected(false);

            } else {
                mainInterestModel.setSelected(true);
                holder.ivMainInterest.setImageResource(R.drawable.bath_selector);

            }
            notifyDataSetChanged();
        }
    });

}