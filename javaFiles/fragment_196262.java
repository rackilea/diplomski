public static void main(String[] args) {
    String Str = "Add more to number";
    String Str2 = "Too much number";
    String Str3 = "Just right";
    int num1 = 0;
    int numToGuess = 7; //you can change this to whatever you want
    Scanner scanIn = new Scanner(System.in);

    //we want to ask for a number until it is the same as our numToGuess
    do {
        System.out.println("How much number");
        num1 = scanIn.nextInt();
        //if the number entered is less let them know
        if(num1 < numToGuess)
        {
            System.out.println(Str);
        }
        else if(num1 > numToGuess)
        {
            System.out.println(Str2);
        }
    } while (num1 != numToGuess); 
    //we will continue to ask until our num1 is equal to numToGuess

    //since we got out we guessed correctly
    System.out.println(Str3);

}//main method