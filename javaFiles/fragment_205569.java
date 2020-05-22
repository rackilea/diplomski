public class SampleJava {
static final String[] CODEWORDS = {
    "ABC",
    "DEF",
    "GHI"};
static public void main(String[] args) {
    String input = "/ABC/DEF/456/GHI/789";
    String codewords = Arrays.stream(CODEWORDS)
            .collect(Collectors.joining("|", "/(", ")/"));
    //     codewords = "/(ABC|DEF|GHI)/";
    Pattern p = Pattern.compile(
/* codewords */ ("(DELIM)"
/* pre-delim */ + "|(.+?(?=DELIM))"
/* final bit */ + "|(.+?$)").replace("DELIM", codewords));
    Matcher m = p.matcher(input);
    while(m.find()) {
        System.out.print(m.group(0));
        if(m.group(1) != null) {
            System.out.print(" ← code word");
        }
        System.out.println();
    }
}
}