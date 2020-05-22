public static Boolean getYNConfirm(Scanner src, String prompt){
  String input = "";
  boolean done=true;
  System.out.println(prompt + " Y or N");
  while(!done){
    input = src.nextLine();
    if(input.equalsIgnoreCase("Y")){
      done=true;
    } else if(input.equalsIgnoreCase("N")) {
      done=false;
    } else {
      System.out.println("Y or N");
    }
  }
  return done;
}