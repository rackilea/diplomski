public static void main(String args[])
        {
          String original,input;
          Scanner sc=new Scanner(System.in);

          System.out.println("Enter word and I will tell you if it has the property of a      palindrome: ");
          original = sc.nextLine();

        do{

          char firstLetter = original.charAt(0);
          input = original.substring(1);
          input = input + firstLetter;

          StringBuilder input2=new StringBuilder(input).reverse();
          String s2=new String(input2);



            if(original.equals(s2))
                System.out.println(original + " has a Palindrome property");
            else
                System.out.println(original + " does not have a Palindrome property");
                System.out.println("Enter another word. Or enter \"quit\" to end");
                original = sc.nextLine();
            } while (!(original.equalsIgnoreCase("quit")));

       }

}