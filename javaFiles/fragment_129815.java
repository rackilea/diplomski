public static int askState(String[] stateNames) {
    Scanner keyboard = new Scanner(System.in);
    String state;
    int statePosition = -1;
    System.out.println("Please enter a state that you would like to search:");
    state = keyboard.nextLine();
    {
        for (int i = 0; i < NUM_STATES; i++) {
            if (state.equals(stateNames[i])){ 
                statePosition = i;
                return stateposition;
            }
        }
        System.out.println("Please enter a valid state:");          
    }
    return statePosition;

}

}