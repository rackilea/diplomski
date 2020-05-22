int theNumber = S.nextInt();
if (theNumber < 1000 || theNumber > 9999) {
    System.out.println("Sorry, but that is not a four digit number. Program will terminate.");
    System.out.println("Thank you for using Zito's 4-digit Encrypter program.");
}
else {
    // I'm leaving this up to you to figure out how to get each digit.
    // There are several ways to do it, and it's out of scope for this question anyway.
    int digit1 = ...
    int digit2 = ...
    int digit3 = ...
    int digit4 = ...

    int a = digit1 % 10 + 7; 
    int b = digit2 % 10 + 7;
    int c = digit3 % 10 + 7;
    int d = digit4 % 10 + 7;

    System.out.print("The encrypted version of your input is ");

    System.out.print(a);
    System.out.print(b);
    System.out.print(c);
    System.out.print(d);
}