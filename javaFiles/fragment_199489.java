int[] ar = {5,6,7,3,6,10};
    int halflen= (ar.length)/2;
    int[] result = new int[halflen];

    for(int i=0,j=halflen;i<halflen;i++,j++)
    {
        result[i]=ar[i]-ar[j];
    }