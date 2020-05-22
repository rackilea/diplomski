public static void main(String[] args) {
        RecursivePalindrome  Pal = new RecursivePalindrome ();

        Scanner in = new Scanner(System.in);
        while(true){
             System.out.print("Enter a word to test whether it is a palindrome or not(press quit to end.): ");
             String x = in.nextLine();
                boolean itsPal = Pal.isPal(x);
                if(itsPal == true){
                    System.out.println(x + " is a palindrome.");
                } else if (x.equals("quit")) {
                    break;
                } else {
                    System.out.println(x + " is not a palindrome.");
                }
        }
    }
}