public static int countDigits( int num )
{
    return (String.valueOf(num)).length();
}

public static double sumDigits( int num )
{
    double sum=0.0;
    while (num > 0) {
        sum += num % 10;
        num = num / 10;
    }
    return sum;
}

public static double averageDigits( int num )
{
    return sumDigits(num) / countDigits(num);
}