public static void makeGuess(){
    int number = getFinal(); //number to be guessed

    myLoop:
         while(true){ //loop until they get it right
              Scanner scan = new Scanner(System.in);
              int pick = scan.nextInt();
              if(pick > number){
                  System.out.println("Your number is too high.");            
              }else if(pick < number){
                  System.out.println("Your number is too low.");
              }else if(pick == number){
                  System.out.println("Correct!");
                  break myLoop;
              }
         }
}