public static double sum(Scanner input){
  double sumAnswer = 0;
  while (input.hasNext()){
    sumAnswer += input.nextDouble();
  }
  return sumAnswer;
}