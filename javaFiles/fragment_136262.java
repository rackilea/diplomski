public class YearHolder extends TreeNode.BaseNodeViewHolder<YearHolder.IconTreeItem> {

    public YearHolder (Context context ) {
        super(context);
    }

    @Override
    public View createNodeView(TreeNode node, IconTreeItem value) {
        final LayoutInflater inflater = LayoutInflater.from(context);
        final View view = inflater.inflate(R.layout.custom_notes_view, null, false);
        TextView tvValue = (TextView) view.findViewById(R.id.text_title);
        tvValue.setText(value.text);

        return view;
    }

    public static class IconTreeItem {
        public int icon;
        public String text;

        IconTreeItem(int icon_, String text_) {
            this.icon = icon_;
            this.text = text_;
        }
    }
}