private static void addAnnotationProcessorOption(String compilerArg, Map<String, String> optionsMap) {
  if (compilerArg == null || compilerArg.trim().isEmpty()) return;

  if (compilerArg.startsWith("-A")) {
    int idx = compilerArg.indexOf('=', 3);
    if (idx >= 0) {
      optionsMap.put(compilerArg.substring(2, idx), compilerArg.substring(idx + 1));
    } else {
      optionsMap.put(compilerArg.substring(2), "");
    }
  }
}