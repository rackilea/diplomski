public class Test {

    public static void main(String[] args) {
        String haystack = "<p><a href='bla'>(UPDATE)</a></p><p><a href='bla'><strong>(UPDATE)</strong></a></p><p><a href='bla'><strong>(Non uppercase 'update' to show this match is exact)</strong></a></p><p><a href='bla'><strong>This does not contain the word you're looking for</strong></a></p>";
        String regex = "<p>.*?(UPDATE).*?</p>";

        String result = haystack.replaceAll(regex, "");
        System.out.println("Result: " + result);
    }
}