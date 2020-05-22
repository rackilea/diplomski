public static void main(String[] args)
{
    System.out.println("Enter a word to determine if it is a palindrome: ");     
    word = type.nextLine();                  //user types word

    if(Palindrome.isPalindrome(word)) {        
        System.out.println("is a palindrome");
    } else {
        System.out.println("is not a palindrome\n");
    }
} // End of main