public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    System.out.println("guess the number between 1 and 9");

    int random = (int)(Math.random() * 9 + 1);

    int value = 0;
    do{
        value = scanner.nextInt();

        if (value != random){
            System.out.println("Try again");
        }

    }


    while(value != random);

    System.out.println("You guessed the number");   

    if(value == random){
        System.out.println("Would you like to restart?");
        String reset = scanner.nextLine();
        if (reset.equals("restart")){
            main(args); // restart you code
            return;
        }
    }   
}