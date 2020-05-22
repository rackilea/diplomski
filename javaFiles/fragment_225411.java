public static boolean getYNConfirm(Scanner src, String prompt){
  String input = "";
  System.out.println(prompt + " Y or N");
  while(true){ //Loops forever until a return or break statement 
    input = src.nextLine();
     if(input.equalsIgnoreCase("Y")){
       return true;
     } else if(input.equalsIgnoreCase("N")) {
       return false;
     } else {
       System.out.println("Y or N");
     }
   }
}