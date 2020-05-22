static List<String> fixMacs(List<String> inMacs) {
    final List<String> outMacs = new ArrayList<>(inMacs.size());
    for (String mac : inMacs) outMacs.add(
          mac.charAt(2) == '-'? mac.replace("-", ":")
        : mac.charAt(2) != ':'? fixMac(mac)
        : mac);
    return outMacs;
  }

  static String fixMac(String inMac) {
    final StringBuilder b = new StringBuilder(18);
    for (int i = 0; i < inMac.length(); i++) {
      b.append(inMac.charAt(i));
      if (i%2 == 1 && i != inMac.length()-1) b.append(':');
    }
    return b.toString();
  }