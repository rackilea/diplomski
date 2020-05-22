public static int convert(String binary)
    {
    int p=0;
    int decimal=0;

    long number=Long.parseLong(binary);
    while(number>0)
    {
      long temp = number%10;
         decimal += temp*Math.pow(2, p);
         number = number/10;
         p++;
      //write your code here

     }
     return decimal;
    }