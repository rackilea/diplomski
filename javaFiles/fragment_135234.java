private boolean validate(String... items) {
  for (String item : items) {
    if (TextUtils.isEmpty(item)) {
      return false;
    }
  }
  return true;
}