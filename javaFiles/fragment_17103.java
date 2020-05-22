public static void countDown(){
  for (int number = 0; number < 100; number++){
    if (number % (3*5) == 0) {
        System.out.println("fizzbuzz");
    } else 
    if (number % 3 == 0){
        System.out.println("fizz");
    } else
    if (number % 5 == 0){
        System.out.println("buzz");
    }
  }
}