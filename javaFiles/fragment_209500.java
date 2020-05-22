public static int greatestCommonFactor(int a, int b)
{
    int result = 1;
    int i = 1 ;
    while (i <= a && i <= b){
        if (a%i == 0 && b%i == 0){
            result = i;
        }
        i++;
    }

    return result;
}