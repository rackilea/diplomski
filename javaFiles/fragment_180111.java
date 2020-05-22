tabFolder.addCTabFolder2Listener(new CTabFolder2Adapter() {
  @Override
  public void close( CTabFolderEvent event ) {
    event.doit = false; // disallow close
  }
}