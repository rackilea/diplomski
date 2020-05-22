for (double i=1; prices != 0; i++)
{
    prices = sc.nextInt();
    if (prices == 0) {
        break;
    }
    if (prices < 500)
    {
        smaller500++;
    }
    sum += prices;
    average = i;
    if (prices > mostExpensive )
    {
        mostExpensive = prices;
    }
}