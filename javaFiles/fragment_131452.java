Map<?, ?> desktopHints = 
    (Map<?, ?>) Toolkit.getDefaultToolkit().getDesktopProperty("awt.font.desktophints");

Graphics2D g2d = (Graphics2D) g;
if (desktopHints != null) {
    g2d.setRenderingHints(desktopHints);
}
// no need to set more rendering hints