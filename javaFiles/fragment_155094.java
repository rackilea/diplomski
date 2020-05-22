(?m)^.*\bMary\b((?!\bBob\b).)*\bare\b.*$


public class Main {
    public static void main(String[] args) {
        String[] tests = {
                "Mary and Rob are married",
                "Mary and John and Michael became good friends and are living together",
                "Mary, Rob and Bob are dead"
        };
        String regex = "(?m)^.*\\bMary\\b((?!\\bBob\\b).)*\\bare\\b.*$";
        for(String t : tests) {
            System.out.println(t.matches(regex) + " -> " + t);
        }
    }
}