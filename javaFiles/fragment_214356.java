for (int i = 0; i < containerView.getChildCount(); i ++) {
    View view = containerView.getChildAt(i);
    if (view instanceof TextView) {
        TextView textView = (TextView) view;
        textView.setText(yourText);
    }
}