public static void main (String[] args) throws java.lang.Exception
{
    Scanner userInput = new Scanner(System.in);    
    String binary;
    int answer = 0;
    System.out.println("Welcome to the Binary to Denary converter!");
    System.out.println("Please enter an 8-BIT Binary value:");

    binary = userInput.next();

    for (int i = 0; i < binary.length(); i++) {
        if (binary.charAt(i) == '1') {
            answer += java.lang.Math.pow(2, binary.length() - i - 1);
        }   
    }

    System.out.println("Your Denary value is:"+answer);
}