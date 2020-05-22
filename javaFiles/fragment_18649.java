Component visibleComp = null;
for (Component comp : cardPanel.getComponents()) {
  if (comp.isVisible()) {
    visibleComp = comp;
    break;
  }
}