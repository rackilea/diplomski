public class PersonTest {
    public static void main(String[] args) {
        Person2 user1 = new Person2(false, true);
        user1.setName("John Doe");
        user1.setYear(1986);
        System.out.println("The clients name is " + user1.getName() + ".");
        System.out.println("The client is " + user1.getAge(1986) + ".");
        System.out.println(user1.getStatus(user1.getAge(1986)));

        Person2 user2 = new Person2(true, false);
        user2.setName("Mary Joe");
        user2.setYear(1975);
        System.out.println("The clients name is " + user2.getName() + ".");
        System.out.println("The client is " + user2.getAge(1975) + ".");
        System.out.println(user2.getStatus(user2.getAge(1975)));

        Person2 user3 = new Person2(false, false);
        user3.setName("Forrest Burtner");
        user3.setYear(1924);
        System.out.println("The clients name is " + user3.getName() + ".");
        System.out.println("The client is " + user3.getAge(1924) + ".");
        System.out.println(user3.getStatus(user3.getAge(1924)));

        Person2 user4 = new Person2(false, false);
        user4.setName("John Connor");
        user4.setYear(1910);
        System.out.println("The clients name is " + user4.getName() + ".");
        System.out.println("The client is " + user4.getAge(1910) + ".");
        System.out.println(user3.getStatus(user4.getAge(1910)));
    }
}