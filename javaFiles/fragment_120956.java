private static final Map<Predicate<String>, String> VALIDATIONS = new LinkedHashMap<> ();

static {
  VALIDATIONS.put(Validator::isAccept1, "fail1");
  VALIDATIONS.put(Validator::isAccept2, "fail2");
  //etc.
}

public String mainValidate(String value) {
  for (Entry<Predicate<String>, String> v : VALIDATIONS.entrySet()) {
    Predicate<String> validator = v.getKey();
    String errorMsg = v.getValue();
    if (!validator.test(value)) return errorMsg;
  }
  return "ok";
}

public static boolean isAccept1(String value) { return /* ... */; }