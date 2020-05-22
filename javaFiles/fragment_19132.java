boolean usesConstantValue = element.accept(new ConstantValueDetector(), null);

...

private static class ConstantValueDetector extends SimpleElementVisitor8<Boolean, Void> {
  @Override
  public Boolean visitVariable(VariableElement e, Void aVoid) {
    super.visitVariable(e, aVoid);
    return e.getConstantValue() != null;
  }
}