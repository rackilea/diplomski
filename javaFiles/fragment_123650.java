int temp;

for (int count = 0; count < 4; count++)
{
    if ( number2 < number1)
    {
       temp = number1;
       number1 = number2;
       number2 = temp;
    }

    if ( number3 < number2)
    {
       temp = number2;
       number2 = number3;
       number3 = temp;
    }

    if ( number4 < number3)
    {
       temp = number3;
       number3 = number4;
       number4 = temp;
    }

    if ( number5 < number4)
    {
       temp = number4;
       number4 = number5;
       number5 = temp;
    }
}

System.out.println( number1 + " " + number2 + " " + number3 + " " + number4 + " " + number5);
System.out.println( number5 + " " + number4 + " " + number3 + " " + number2 + " " + number1);