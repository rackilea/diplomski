public static int productFinder(int... num)
{
    int product = 1;
    for(int i = 0; i < num.length; i++) {
        product *= num[i];
    }
    return product;
}