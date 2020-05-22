private ImageView myView;// populated in onCcreate

private void moveImage(int x, int y) {
    ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams)myView.getLayoutParams();
    lp.leftMargin = x;
    lp.rightMargin = y;
    requestLayout();
}