public class DeletAble {

    public static void main(String[] args) {

        // Your code is esentally shorthand for the following code
        String userName = "sdfsd"                                       // Value "sdfsd"
        String firstLetter = userName.substring(0,1).toUpperCase();     // Value "S"
        String rest = userName.substring(1).toLowerCase();              // Value "dfsd"
        userNmame = firstLetter + rest;                                 // Value "Sdfsd

        // Prints emmpty string "Sdfsd"
        System.out.println(userName);
    }
}