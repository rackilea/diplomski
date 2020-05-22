public class testprog {
    public static void checkString (String s) {
        boolean yes = s.matches(".*[/\\\\].*");
        System.out.println ("'" + s + "': " + yes);
    }

    public static void main (String s[]) {
        checkString ("Hi/Hello/Bye/");
        checkString ("Hi\\Hello\\Bye\\");
        checkString ("Hi\\Hello/Bye\\");
        checkString ("HiHelloBye");
    }
}