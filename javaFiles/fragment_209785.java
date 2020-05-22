public static void main(String[] args) {
    Scanner sc = new Scanner(System. in );
    System.out.print("Please enter the first name of the person you would love to know about : ");
    String hisName = sc.next();
        printSomeInfoAbout(hisName);

  System.out.print("AGAIN (Y/N) : ");  // ask the input from user
    String var= sc.next();
   if(var.equalsIgnoreCase("Y")){// Matches "Y" or "y"
      main(null); // if input is Y then call main again. 
   }
}