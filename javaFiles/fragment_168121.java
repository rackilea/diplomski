builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialog, int which) {
        m_text = input.getText().toString();
        config.addNewCategoryWithViewOrder(new Category(m_text, R.drawable.ic_books, -1));
        rv.getAdapter().notifyItemRangeInserted(config.getCategorySize() - 2, 1);  // I would rather used notifyItemInserted()
        rv.scrollToPosition(config.getCategorySize() - 1);
    }
});