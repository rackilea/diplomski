for(int i = 0; i < 25; i++){
System.out.println("Enter an integer from 0 to 100");
    //numIn = -1; ---- SOMETHING I TRIED
    Scanner in = new Scanner(System.in);
    numIn = in.nextInt();

    if(numIn==goal){
    System.out.println("Congratulations, you win the game!");
    return 0; //return 0 indicates a normal completion of the program
    }...etc
}
System.out.println("Out of turns. Too bad, you lose...") //Just a suggestion, but an explanation of why the game just stopped is good, no?
return 0;