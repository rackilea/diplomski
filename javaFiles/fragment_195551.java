public class NumberTranslator  {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // Ask the user to enter the phone number
    System.out.println("Please enter the Phone number in this format: (555-XXX-XXXX) ");

    // Save the phone number into a string
    String phoneNumber = input.nextLine();
    // phoneNumber = phoneNumber.substring(0, 3) + "-" +
    // phoneNumber.substring(3,6)+"-"+phoneNumber.substring(6,10)+"-";

    phoneNumber = phoneNumber.toUpperCase();
    String phoneNumberTranslated = fullPhoneNumber(phoneNumber);

    System.out.println(phoneNumberTranslated);
  }

  public static String fullPhoneNumber(String phoneNumber) {

    StringBuilder result = new StringBuilder();

    long number = 0;
    int strLength = phoneNumber.length();

    for (int i = 0; i < strLength; i++) {

      char letter = phoneNumber.charAt(i);

      if (Character.isLetter(letter)) {

        switch (letter) {
          case 'A': case 'B': case 'C': number = 2; break;
          case 'D': case 'E': case 'F': number = 3; break;
          case 'G': case 'H': case 'I': number = 4; break;
          case 'J': case 'K': case 'L': number = 5; break;
          case 'M': case 'N': case 'O': number = 6; break;
          case 'P': case 'Q': case 'R': case 'S': number = 7; break;
          case 'T': case 'U': case 'V': number = 8; break;
          case 'W': case 'X': case 'Y': case 'Z': number = 9; break;
        }
      }

      else if (Character.isDigit(letter)) {
        number = Character.getNumericValue(letter);
      } else {
        System.out.println("Invalid character!");
      }
      result.append(String.valueOf(number));
    }
    return result.toString();
  }
}