class TradeSection extends StatelessSection {

    List<String> list;

    public TradeSection(List<String> list) {
        // call constructor with layout resources for this Section header, footer and items 
        super(-1, R.layout.section_item, R.layout.section_footer);

        // remove header
        this.setHasHeader(false);

        this.list = list;
    }

    @Override
    public int getContentItemsTotal() {
        return list.size(); // number of items of this section
    }

    @Override
    public RecyclerView.ViewHolder getItemViewHolder(View view) {
        // return a custom instance of ViewHolder for the items of this section
        return new MyItemViewHolder(view);
    }

    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyItemViewHolder itemHolder = (MyItemViewHolder) holder;

        // bind your view here
        itemHolder.tvItem.setText(list.get(position));
    }

    @Override
    public RecyclerView.ViewHolder getFooterViewHolder(View view) {
        return new MyFooterViewHolder(view);
    }

    @Override
    public void onBindFooterViewHolder(RecyclerView.ViewHolder holder) {
        MyFooterViewHolder footerHolder = (MyFooterViewHolder) holder;

        // bind your footer view here
        footerHolder.tvItem.setText(title);
    }
}