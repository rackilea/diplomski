public class RegexpExample {

public static void main(String[] args) {
    String song = "Is this a real life? Is this just fantasy?";
    String toFind = "is";

    Pattern p = Pattern.compile(toFind, Pattern.CASE_INSENSITIVE);
    Matcher m = p.matcher(song);

    while (m.find()) {
        String found = m.group();
        int startIndex = m.start();
        int endIndex = m.end();

        System.out.println(found + " at start " + startIndex + ", end " + endIndex);
        //do something with this info...
    }
}