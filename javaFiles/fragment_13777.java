Element compilerArgs = compilerConfig.getChild("compilerArgs");
if (compilerArgs != null) {
  for (Element e : compilerArgs.getChildren()) {
    if (!StringUtil.equals(e.getName(), "arg")) continue;
    String arg = e.getTextTrim();
    addAnnotationProcessorOption(arg, res);
  }
}