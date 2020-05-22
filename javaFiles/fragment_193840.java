static String replaceEscapes(String s) {
        return s.replaceAll("\n", "<linefeed>")
        .replaceAll("\r", "<carriage return")
        .replaceAll("\t", "<tab>")
        .replaceAll("\b", "<backslash>")
        .replaceAll("\f", "<formfeed>");
  }