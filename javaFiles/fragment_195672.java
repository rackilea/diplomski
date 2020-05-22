public static String bashEscape(String[] arguments) {
    StringBuilder sb = new StringBuilder();
    for(String arg : arguments) {
      if (arg.indexOf(0) != -1) {
        throw new IllegalArgumentException("Shell arguments can't represent NUL bytes");
      }
      sb.append("'").append(arg.replaceAll("'", "'\\\\''")).append("' ");
    }
    return sb.toString();
  }