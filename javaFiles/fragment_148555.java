public class MatcherMatch {

public static void main(String[] args) {
    Pattern pattern = Pattern.compile("\\p{IsHangul}");
    Matcher matcher  = pattern.matcher("김인재 한국어/조선말");
    while(matcher.find()) {
        System.out.println(matcher.group());
    }
}