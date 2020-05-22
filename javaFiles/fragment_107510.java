private boolean mAreCheckboxesVisible = false;
// ...
@Override
public void onBindViewHolder(final MyViewHolder holder, final int position) {
    // ...
    holder.checkBox.setVisibility(mAreCheckboxesVisible ? View.VISIBLE : View.GONE);
    holder.cardView.setOnLongClickListener(new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) {
            mAreCheckboxesVisible = true;
            notifyDataSetChanged();
            return true;
        }
    });
}