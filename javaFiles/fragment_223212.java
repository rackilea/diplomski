private static final Set<String> RTL;

static {
  Set<String> lang = new HashSet<String>();
  lang.add("ar");
  lang.add("dv");
  lang.add("fa");
  lang.add("ha");
  lang.add("he");
  lang.add("iw");
  lang.add("ji");
  lang.add("ps");
  lang.add("sd");
  lang.add("ug");
  lang.add("ur");
  lang.add("yi");
  RTL = Collections.unmodifiableSet(lang);
}

public static boolean isTextRTL(Locale locale) {
  return RTL.contains(locale.getLanguage());
}