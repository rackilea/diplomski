@Override
public void onBindViewHolder(ViewHolder holder, int position) {
    if (TextUtils.isEmpty(viewModel.getTitle())) {
        holder.itemView.setVisibility(View.GONE);
    }
}