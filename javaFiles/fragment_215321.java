@Override
  public void adjustmentValueChanged(AdjustmentEvent e) {
  if(isScrollingDownRequired) {
    e.getAdjustable().setValue(e.getAdjustable().getMaximum());
    isScrollingDownRequired = false;
  }
}