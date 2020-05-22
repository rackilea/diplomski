for(int j=0;j<2;j++)
{
    for(int i=0;i<m+n;i++)
    {
        if(i<m)
            arr3[i]=arr1[i];
        else
            arr3[i]=arr2[i%m];
    }
}