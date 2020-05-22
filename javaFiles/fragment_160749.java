public class Client {

    public static void main(String[] args) {
        // String container
        Container<String> stringContainer = new StringContainer();
        stringContainer.setItem("Test");
        //stringContainer.setItem(new StringBuffer("")); // compilation error, type safety checking 

        System.out.println(stringContainer.getItem().toUpperCase()); // No need to cast

    }

}