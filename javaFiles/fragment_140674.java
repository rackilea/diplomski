while( number >0)
{
    reverse1 = reverse1 * 10;
    reverse1 = reverse1 + number%10;
    number = number/10;
}
while( number2 >0)
{
    reverse2 = reverse2 * 10;
    reverse2 = reverse2 + num%10;
    num = num/10;
}

System.out.println(reverse1+reverse2);