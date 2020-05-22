recylerView.setLayoutManager(new LinearLayoutManager(this) {
    @Override
    public boolean requestChildRectangleOnScreen(RecyclerView parent, View child, Rect rect, boolean immediate) {
        return false;
    }
});