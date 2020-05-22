public Wrapper {
  private Keyclass key;
  ...

  public Keyclass getWrapped() { return key; }

  @Override
  public int hashCode() {
    return key.objID.hashCode();
  }

  @Override
  public boolean equals(Object o) {
    return key.objID.equals(((Wrapped)o).key.objID);
  }
}