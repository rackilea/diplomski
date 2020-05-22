private static Boolean isDivisibleBy(int x, int divisor)
{
    char[]b=String.valueOf(x).toCharArray();
    //Store all your digits as characters
    int[]no= new int[b.length];
    for (int i=0;i<b.length;i++)
       no[i]=Integer.parseInt(String.valueOf(b[i]));
    //Now no contains all your integers as an array 
    if(divisor==2)
           return isDivisibleBy2(no);
    else if(divisor==3)
           return isDivisibleBy3(no);
    else if(divisor==4)
           return isDivisibleBy4(no);
    //...................
    else return false;
}