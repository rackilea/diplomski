if (event.isDataFlavorSupported(dataFlavor)) {
    event.acceptDrop(DnDConstants.ACTION_MOVE);
    panel.add(an);
    panel.revalidate();
    event.dropComplete(true);
    return;
}