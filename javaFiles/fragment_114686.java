clipboard.setContents(new Transferable() {
    public DataFlavor[] getTransferDataFlavors() {
      return new DataFlavor[0];
    }

    public boolean isDataFlavorSupported(DataFlavor flavor) {
      return false;
    }

    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException {
      throw new UnsupportedFlavorException(flavor);
    }