if (image != null) {
    Rectangle inner = SwingUtilities.calculateInnerArea(this, null);

    Insets margin = getMargin();
    inner.x += margin.left;
    inner.y += margin.top;
    inner.width -= (margin.left + margin.right);
    inner.height -= (margin.top + margin.bottom);

    g.drawImage(image, inner.x, inner.y, inner.width, inner.height, this);
}