public class CleanPhoneNumber {

    public static void main(String[] args) {
        String inputPhoneNumber = "+91 – 9871127622";
        String validPhoneNumber = cleanup(inputPhoneNumber);
        System.out.println(validPhoneNumber );
    }

    public static String cleanup(String inputPhoneNumber) {
        return inputPhoneNumber.replaceAll("[^\\d]", "");
    }

}