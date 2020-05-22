public static void PrintAsterisk(int N)
{
    if (N==1) {
        PrintAsteriskLine(N);
    } else {
        PrintAsteriskLine(N);
        PrintAsterisk(N-1);  
    }
}// end PrintAsterisk