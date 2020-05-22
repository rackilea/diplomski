myCustomView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
    @Override
    public void onGlobalLayout() {
        myCustomView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        do_your_logic_to_save_bitmap_from_view;
    }
});