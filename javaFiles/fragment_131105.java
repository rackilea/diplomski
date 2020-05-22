try{
    int age = Integer.parseInt(console.readLine("Enter your age:  "));
    // do stuff
} catch (NumberFormatException e) {
    // User did not enter a number
}