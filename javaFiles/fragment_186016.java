if (event.isDataFlavorSupported(dataFlavor)) {
    event.acceptDrop(DnDConstants.ACTION_MOVE);
    this.panel.add(an);
    event.dropComplete(true);
    this.panel.validate();
    this.panel.repaint();
    return;
}