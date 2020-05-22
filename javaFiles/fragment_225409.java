public static double getRangedDouble(Scanner src, String prompt, double lo, double hi){
  double retVal = lo - 1;
  String trash;
  do{
    System.out.print(prompt + " " + lo + " - " + hi);
    if(src.hasNextInt()){
       retVal = src.nextInt();
    } else {
       trash = src.nextLine();
    }
  } while(retVal < lo || retVal > hi);
  return retVal;
}