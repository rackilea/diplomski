// Although we have measured the layout, we need to tell ConstraintLayout in the
// LayoutParams that the size is not longer "wrap_content".
ViewGroup.LayoutParams lp = getLayoutParams();
lp.width = width;
lp.height = height;
setLayoutParams(lp);