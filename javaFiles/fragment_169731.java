private static final EnumMap<ExitCode, Runnable> runOnOption = new EnumMap<> (ExitCode.class);

static {
  runOnOption.put(ERROR, () -> LOG.error("an error occurred"));
  runOnOption.put(SUCCESS, () -> LOG.info("success"));
  runOnOption.put(FATAL, this::runOnFatal);
}

private static void runOnFatal() {
  //more complex recovery code
}