public class TestCompare {
public static void main (String[]args) {

    String firstString = "hello";


    boolean containsMySearch;

     firstString = firstString.toUpperCase();
            containsMySearch = firstString.contains("llo");

            System.out.println("returns " + containsMySearch);

}
}