class ChainedSelectionEvent extends TreeSelectionEvent {
  ChainedSelectionEvent(TreeSelectionEvent e) {
    super(e.newSource, e.paths, e.areNew, e.oldLeadSelectionPath, e.newLeadSelectionPath);
  }
}

protected void fireValueChanged(TreeSelectionEvent e) {
  if(chained) { // figure out separately
      super.fireValueChanged(new ChainedSelectionEvent(e));
  } else {
      super.fireValueChanged(e);
  }
}