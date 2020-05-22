int digit1 = loop1.charAt(0) - '0';
int digit2 = loop1.charAt(1) - '0';
int number = digit1 * 10 + digit2;
if ( number <= 90 && number >= 0 )
    System.out.println("Input is good");
else
    System.out.println("Input is bad");