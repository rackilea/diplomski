public void setForeground(Color fg) {
    Color oldFg = getForeground();
super.setForeground(fg);
if ((oldFg != null) ? !oldFg.equals(fg) : ((fg != null) && !fg.equals(oldFg))) {
    // foreground already bound in AWT1.2
    repaint();
}
}