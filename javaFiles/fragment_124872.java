class ChildB extends Base {
  public ChildB(ChildA sibling) {
    super(sibling);
  }

  @Override
  public ChildA getSibling() {
    return (ChildA) super.getSibling();
  }
}