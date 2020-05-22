private static class ViewHolder {
    public final RelativeLayout rootView;
    public final TextView textViewCategoryName;

    private ViewHolder(RelativeLayout rootView, TextView textViewCategoryName) {
        this.rootView = rootView;
        this.textViewCategoryName = textViewCategoryName;
    }

    public static ViewHolder create(RelativeLayout rootView) {
        TextView textViewCategoryName = (TextView) rootView.findViewById(R.id.textViewCategoryName);
        textViewCategoryName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Do whatever you want
            }
        });
        return new ViewHolder(rootView, textViewCategoryName);
    }
}