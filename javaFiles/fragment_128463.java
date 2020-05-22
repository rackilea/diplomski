protected void alignVerticalAlingment() {
    int fontSize = getLineCount() * getLineHeight();
    if (getHeight() > 0) {
            setPadding(getPaddingLeft(), 0, getPaddingBottom(), 0);
            int height = getHeight();
            int y = (fontSize - height + (int) getPaint()
                    .descent()) / 2;
            scrollTo(0, y);
    }
}