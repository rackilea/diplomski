public void onBindViewHolder(TableItemViewHolder holder, int position) {
    Table table = mTableList.get(position);
    holder.mTableNameTextView.setText(table.getTableName());
    holder.tableItemLayout.setSelected(selectedPosition==position);
    if(table.getOrderID()!=0 && selectedPosition!=position)
    {
        Log.i("OrderId",table.getTableName()+table.getOrderID());
        holder.tableItemLayout.setBackgroundColor(mContext.getResources().getColor(R.color.colorAmber));
    }else{
// Reset background color
}
    holder.tableItemLayout.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    notifyItemChanged(selectedPosition);
                    selectedPosition = position;
                    notifyItemChanged(selectedPosition);
                }
            }
    );
}