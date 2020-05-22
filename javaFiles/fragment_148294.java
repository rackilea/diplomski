do
    {
        arr[i++]=sum%10;
        sum/=10;
    }while(sum>0);
    for(int p=i;p>=0;p--)
    {
        mag(arr[p-1]);
    }