for (int i = 1; i <= value; i++) {
    input.nextLine(); //add this to top
    System.out.print("Player " + i + ", Please Enter your name : ");
    String PlayerName = input.nextLine();
    System.out.print("Please enter a number between 0 and 9 : ");
    int PlayerNumber = input.nextInt();

    System.out.println(PlayerName + " : " + PlayerNumber);
}