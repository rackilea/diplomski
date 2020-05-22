try {
  internalFrame.setMaximum(true);
} catch (PropertyVetoException e) {
  // Vetoed by internalFrame
  // ... possibly add some handling for this case
}