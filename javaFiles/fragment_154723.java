public class EnumValueOf {
    enum Gender {
        MALE, FEMALE;
    }
    public static void main(String[] args) {
        Gender g = Gender.valueOf("MALE");
        System.out.println(g);
        // prints "MALE"
        System.out.println(g == Gender.MALE);
        // prints "true"
    }
}