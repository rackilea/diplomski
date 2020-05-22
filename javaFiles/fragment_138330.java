public static void main(String[] args) {
    int option = 0; // declare before the loop so that you can use it in the while condition
    option = menu(); // call the menu first here once
    do {
        // int option = 0; // not needed as declared before
        // option = menu(); // not needed as called before
        ...
    } while ((option = menu()) != 3); // everytime you call to get the next option, capture it and use it to continue or terminate the loop
    // the above value in option, if not 3, will be used in the next iteration of do-while loop
    System.out.println("Goodbye");
}