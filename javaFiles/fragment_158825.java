@Override
    public void onBindViewHolder(SectionViewHolder holder, int position) {
        final LineItem item = mItems.get(position);
        final View itemView = holder.itemView;
// The first text is set below. 
        holder.bindText(item.text);
        holder.bindNoteData(item.otherText);
        final GridSLM.LayoutParams lp = GridSLM.LayoutParams.from(itemView.getLayoutParams());

        lp.setSlm(item.sectionManager == LINEAR ? LinearSLM.ID : GridSLM.ID);
        lp.setColumnWidth(mContext.getResources().getDimensionPixelSize(R.dimen.grid_column_width));
        lp.setFirstPosition(item.sectionFirstPosition);
        itemView.setLayoutParams(lp);
    }