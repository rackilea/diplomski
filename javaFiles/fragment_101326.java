using(new Converter<SourceBigThing, TargetColorThing>(){
  public TargetColorThing convert(MappingContext<SourceBigThing, TargetColorThing> context) {
    TargetColorThing target = new TargetColorThing();
    if (context.getSource().getGreen() != null)
      target.setName(context.getSource().getGreen().getName());
    else if (context.getSource().getRed() != null)
      target.setName(context.getSource().getRed().getName());
    return target;
}}).map(source).setThing(null);