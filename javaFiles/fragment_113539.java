public class VowelCount{
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter a sentence :");
    String sentence = scan.nextLine();

    String vowels = "aeiouAEIOU";
    int vowelCount = 0;
    int consCount = 0;
    int i;

    int length = sentence.length();
    for(i = 0; i < length; i ++){
        char currentChar = sentence.charAt(i);
        if (vowels.indexOf(currentChar)>=0)
           vowelCount++;
        else if(Character.isLetter(currentChar))
                consCount++;
    }
    System.out.print(consCount+";");
    System.out.print(vowelCount);
  }
}