private String hintText = "Hint";

@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    if (getDocument().getLength() == 0) {

        Rectangle viewBounds = new Rectangle();
        SwingUtilities.calculateInnerArea(this, viewBounds);

        Insets margin = getMargin();
        viewBounds.x += margin.left;
        viewBounds.y += margin.top;
        viewBounds.width -= (margin.left + margin.right);
        viewBounds.height -= (margin.top + margin.bottom);

        Rectangle iconBounds = new Rectangle();
        Rectangle textBounds = new Rectangle();

        SwingUtilities.layoutCompoundLabel(this,
            g.getFontMetrics(), hintText, null,
            CENTER, getHorizontalAlignment(), CENTER, LEADING,
            viewBounds, iconBounds, textBounds, 0);

        // paintComponent must leave its Graphics argument unchanged.
        Color originalColor = g.getColor();

        g.setColor(Color.LIGHT_GRAY);
        g.drawString(hintText,
            textBounds.x, getBaseline(getWidth(), getHeight()));

        g.setColor(originalColor);
    }
}