public class Test {
    public static String name = "Andrew";
    public static String fullName = name + " Barnes";
    public static void main(String[] args){
        name = "Barry";
        System.out.println(name); // Barry
        System.out.println(fullName); // Andrew Barnes
    }
}