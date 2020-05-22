boolean palindrome = true;
for(int i = 0; i < (A.length() / 2); i++)
{
    if (A.charAt(i) != A.charAt(A.length() - i - 1)) {
        palindrome = false;
        break;
    }
}
if (palindrome) {
     System.out.println("palindrome");
} else {
    System.out.println("not palindrome");
}