public class FormatTest {

  public static String format(String format, String[] args) {
    int argIndex = 0;
    int startOffset = 0;
    int placeholderOffset = format.indexOf("%s");

    if (placeholderOffset == -1) {
        return format;
    }

    int capacity = format.length();

    if (args != null) {
        for (int i=0;i<args.length;i++) {
            capacity+=args[i].length();
        }
    }

    StringBuffer sb = new StringBuffer(capacity);

    while (placeholderOffset != -1) {
        sb.append(format.substring(startOffset,placeholderOffset));

        if (args!=null && argIndex<args.length) {
            sb.append(args[argIndex]);
        }

        argIndex++;
        startOffset=placeholderOffset+2;
        placeholderOffset = format.indexOf("%s", startOffset);
    }

    if (startOffset<format.length()) {
        sb.append(format.substring(startOffset));
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(
      format("This string contains placeholders %s %s %s ", new String[]{"first", "second", "third"})
    );
  }
}