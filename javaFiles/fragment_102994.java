@Override
public void onBindViewHolder(final ViewHolder viewHolder, int i) {
    viewHolder.mRootLayout.removeAllViews();
    viewHolder.mRootLayout.addView(GetResults().get(i));
    // ...
}