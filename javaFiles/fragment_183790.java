public void setCursorLocation(int characterOffset) {

    Layout layout = this.getLayout();

    int line = layout.getLineForOffset(characterOffset);
    mCursorX = layout.getPrimaryHorizontal(characterOffset);
    mCursorBaseY = layout.getLineBaseline(line);
    mCursorBottomY = layout.getLineBottom(line);
    mCursorAscentY = layout.getLineAscent(line);

    this.invalidate();
}