enum SignatureBinder
    implements TargetMethodAnnotationDrivenBinder.ParameterBinder<StringValue> {

  INSTANCE; // singleton

  @Override
  public Class<Signature> getHandledType() {
    return Signature.class;
  }

  @Override
  public MethodDelegationBinder.ParameterBinding<?> bind(AnnotationDescription.Loaded<StringValue> annotation,
      MethodDescription source,
      ParameterDescription target,
      Instrumentation.Target instrumentationTarget,
      Assigner assigner) {
    if (!target.getTypeDescription().represents(String.class)) {
      throw new IllegalStateException(target + " makes illegal use of @Signature");
    }
    StackManipulation constant = new TextConstant("<signature goes here>");
    return new MethodDelegationBinder.ParameterBinding.Anonymous(constant);
  }
}