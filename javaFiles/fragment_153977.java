for (int i = 1; i < N; ++i)
{
    int factorial = 1;
    for (int j = 1; j <= i; ++j) {
         factorial *= j;
    }
    System.out.println(i + "! = " + factorial); 
}