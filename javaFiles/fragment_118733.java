@Override
public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
    holder.tv.setTextSize(20);
    holder.tv.setPadding(5,20,5,20);
    holder.tv.setText(mDataSet.get(position));
}