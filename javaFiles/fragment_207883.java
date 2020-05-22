if ( number1 % 2 == 0)
{
    System.out.println(number1 + " is even, so I take half " + (number1 / 2));
    number1 = number1 / 2;
}
else
{
    System.out.println(number1 + " is odd, so I make 3n + 1 " + ((3 * number1) + 1)
    number1 = (3*number1) + 1;
}