public class Person {

    private int Birthyear;
    private String Sname;
    private String Name;

    public Person() {

    }

    public Person(String n, String s, int b) {
        Name = n;
        Sname = s;
        Birthyear = b;
    }

    public String getName() {
        return Name;
    }

    public String getSname() {
        return Sname;
    }

    public int getBirthyear() {
        return Birthyear;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setSName(String sName) {
        Sname = sName;
    }

    public void setBirthYear(int birthyear) {
        Birthyear = birthyear;
    }

    public static boolean setb(int b) {
        return !(b < 1899 || b >= 2016);
    }

    public static boolean setn(String n) {
        return !n.matches(".*\\d+.*");
    }

    public static boolean sets(String s) {
        return !s.matches(".*\\d+.*");
    }
}