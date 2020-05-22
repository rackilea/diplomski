public class DeletAble {

    public static void main(String[] args) {

        // Your code is esentally shorthand for the following code
        String userName = "sdfsd"           // Value "sdfsd"
        userName = userName.substring(0,1)  // Value "s"
        userName = userName.toUpperCase()   // Value "S"
        userName = userName.substring(1)    // Value ""
        userName = userName.toLowerCase()   // Value ""

        // Prints emmpty string ""
        System.out.println(userName);
    }
}