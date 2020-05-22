public class RegexForPresto {

 public static void main(String[] args) {

    Pattern p = Pattern.compile(Pattern.quote("^M^M rawtostampedMsg^L 48^UT ")); // <-- This line is changed

    String candidateString = "^M^M rawtostampedMsg^L 48^UT 1338802566.906^EOH^name;

    Matcher matcher = p.matcher(candidateString);
    String tmp = matcher.replaceAll("");

    System.out.println(tmp);
}
}