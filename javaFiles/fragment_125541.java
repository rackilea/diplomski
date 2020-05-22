public static String convert(String text) {
    String s = text;
    StringBuffer sb = new StringBuffer();
    Pattern p = Pattern.compile(P13);
    Matcher m = p.matcher(s);
    int max = THREE;
    while (m.find()) {
      if (m.group().length() > max) {
        String replacement = transform(m.group(1));
        m.appendReplacement(sb, replacement);
      }
    }
    return m.appendTail(sb).toString();
  }

  private static String transform(String origin) {
    Character[] result = origin.chars()
        .mapToObj(i -> (char) i)
        .map(theChar -> {
          if (Character.isUpperCase(theChar)) {
            return Character.toLowerCase(theChar);
          } else {
            return Character.toUpperCase(theChar);
          }
        })
        .toArray(Character[]::new);
    return new String(ArrayUtils.toPrimitive(result));
  }