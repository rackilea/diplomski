userInput=keyboard.nextInt();
while (userInput<25 || userInput>100) {
    System.out.println("Invalid amount entered! \n"
                    + "Please enter an amount between 25 cents and 1 dollar");
    userInput=keyboard.nextInt();
}