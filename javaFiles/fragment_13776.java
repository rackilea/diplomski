Element compilerArguments = compilerConfiguration.getChild("compilerArgs");
if (compilerArguments != null) {
  for (Element element : compilerArguments.getChildren()) {
    String arg = element.getValue();
    if ("-proc:none".equals(arg)) {
      return ProcMode.NONE;
    }
    if ("-proc:only".equals(arg)) {
      return ProcMode.ONLY;
    }
  }
}