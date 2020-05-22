public class StringInternExample {
    public static void main(String[] args) {
        String foo1 = "bar";
        String foo2 = "bar";

        String foo3 = new String("Hello, Kitty");
        String foo4 = new String("Hello, Kitty");

        if(foo1 == foo2){ // compare addresses. Same address = no new memory assigned
            System.out.println("No new memory has been assigned for foo2");
        }

        if(!(foo3 == foo4)){ // compare addresses. Different addresses = new memory
            System.out.println("New Memory has been assigned for foo4");
        }

    }
}