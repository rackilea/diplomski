StyledNode styledNode = boxType.accept(new BoxTypeVisitor<StyledNode> {
  @Override
  public StyledNode visit(BlockNode box) {
    return box.styledNode;
  }

  @Override
  public StyledNode visit(InlineNode box) {
    return box.styledNode;
  }

  @Override
  public StyledNode visit(AnonymousBlock box) {
    throw new RuntimeException("Anonymous block box has no style node");
  }
});