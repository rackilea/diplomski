public class Test {

public static void main(String[] args) {
    System.out.println("USERNAME, PASSWORD, EMAIL, FIRST_NAME, LAST_NAME");

    for (int i = 0; i < 5; i++) {
        String username = "test" + i;
        String password = "password" + i;
        String email = "test" + i + "@test.com";
        String firstName = "test".toUpperCase() + i;
        String lastName = "test".toLowerCase() + i;

        System.out.println(username + ", " + password + "," + email + "," + firstName + "," + lastName);
    }

}