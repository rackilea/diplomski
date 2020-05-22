public static String[] Xor(String[] A, String[] B)
{
    int ALen=A.length;
    String[] C=new String[ALen];
    for(int i=0;i<ALen;i++)
    {
        if(A[i].equals(B[i])) // NOT A[i]==B[i]
        {
            C[i]="0";
        }
        else
        {
            C[i]="1";
        }
    }
    return C;
}