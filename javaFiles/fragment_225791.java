int age;

while (true) {   // wil break on sucess 
   Scanner input = new Scanner(System.in);
   System.out.print("\nEnter Age       : "); 
   String AGE = input.nextLine();
    try{
      age = Integer.parseInt(AGE);
      break;  
    }catch (NumberFormatException ex){
        System.out.print("Invalid input " + AGE + " is not a number");
    }
}