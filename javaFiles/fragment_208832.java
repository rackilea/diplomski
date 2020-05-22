Scanner scanner = new Scanner(System.in);
int numerator = 0;
int denominator = 0;
int tempNumer = 0;
int tempDenom = 0;

if((numerator = scanner.nextInt()) != -1)
{
    denominator = scanner.nextInt();
    while((tempNumer = scanner.nextInt()) != -1)
    {
        tempDenom = scanner.nextInt();
        numerator = numerator * tempDenom + tempNumer * denominator;
        denominator = denominator * tempDenom;
    }
}