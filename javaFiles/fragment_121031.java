/**
 * Paints the border for the specified component with the specified
 * position and size.
 */
@Override
public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
    // fake drop shadow effect in case of heavy weight popups
    JComponent popup = (JComponent) c;
    Image hShadowBg = (Image) popup.getClientProperty(ShadowPopupFactory.PROP_HORIZONTAL_BACKGROUND);
    if (hShadowBg != null) {
        g.drawImage(hShadowBg, x, y + height - 5, c);
    }
    Image vShadowBg = (Image) popup.getClientProperty(ShadowPopupFactory.PROP_VERTICAL_BACKGROUND);
    if (vShadowBg != null) {
        g.drawImage(vShadowBg, x + width - 5, y, c);
    }

    // draw drop shadow
    g.drawImage(shadow, x +  5, y + height - 5, x + 10, y + height, 0, 6, 5, 11, null, c);
    g.drawImage(shadow, x + 10, y + height - 5, x + width - 5, y + height, 5, 6, 6, 11, null, c);
    g.drawImage(shadow, x + width - 5, y + 5, x + width, y + 10, 6, 0, 11, 5, null, c);
    g.drawImage(shadow, x + width - 5, y + 10, x + width, y + height - 5, 6, 5, 11, 6, null, c);
    g.drawImage(shadow, x + width - 5, y + height - 5, x + width, y + height, 6, 6, 11, 11, null, c);
}