private void changeViewsState(ViewGroup parent, boolean state) {
    int count = parent.getChildCount();
    for (int i = 0; i < count; i++) {
        View child = parent.getChildAt(i);
        if (child instanceof ViewGroup) {
            changeViewsState((ViewGroup) child, state);
        } else if (child instanceof View) {
            child.setEnabled(state);
        }
    }
}