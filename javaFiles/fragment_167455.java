System.out.println("Enter your age here:");
while (!sc.hasNextInt()) {
    System.out.println("Please enter an integer.");
    sc.next();
}

int age = sc.nextInt();

if(age < 0) {
    //do what you want if the number is negative
    //if you're in a loop at this part of the program, 
    //you can use the continue keyword to jump back to the beginning of the loop and 
    //have the user input their age again. 
    //Just prompt them with a message like "invalid number entered try again" or something to that affect
}
else {
    setAge(age);
    //continue execution
}