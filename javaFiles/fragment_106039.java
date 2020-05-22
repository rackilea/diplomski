taskPane.addPropertyChangeListener(JXCollapsiblePane.ANIMATION_STATE_KEY, new PropertyChangeListener() {
  public void propertyChange(PropertyChangeEvent e) {
    if(e.getNewValue().equals("expanded") {
      ...
    }
    else if(e.getNewValue().equals("collapsed") {
      ...
    }
  }
}