String str = "A quick brown fox jumps over the lazy dog";
Toolkit tk = Toolkit.getDefaultToolkit();
Map desktopHints = (Map)(tk.getDesktopProperty("awt.font.desktophints"));
Graphics2D g2d = (Graphics2D)g;

if(desktopHints != null) {
    g2d.addRenderingHints(desktopHints);
}

g2d.drawString(str, someX, someY);