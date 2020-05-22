class Reverse{
   public static void main(String args[]){
   Scanner word = new Scanner(System.in);
   System.out.print("type the word here to check if it is palindrome: ");
   String n = word.nextLine();
   char[] let = n.toCharArray();
   System.out.print(reverse(let));
   // for (int i=let.length-1; i>=0; --i){
      // System.out.print(let[i]);
   // }

 }
 public static char[] reverse(char[] let){
   char[] reversed = new char[let.length];
    for (int i = 0; i < let.length; i++) {
        reversed[i] = let[let.length - 1 - i];
    }
  return reversed;
 }  
}