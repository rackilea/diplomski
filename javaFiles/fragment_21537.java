public class RegExpTest {

  public static void main(String[] args) {

    String text =
        "if (\"drinks\" == selectedValue) {\nproductSelect.options[productSelect.options.length] = new Option(\"lipton ice tea  [1.71]\",\n\"lipton ice tea\", false, false);\n}";
    String patternString = "if \\(\"(.*)==";
    Pattern pattern = Pattern.compile(patternString);
    Matcher matcher = pattern.matcher(text);

    if (matcher.find()) {
      System.out.println("Result: '" + matcher.group(1) + "'");
    }
  }
}