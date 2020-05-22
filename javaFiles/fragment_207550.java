int HoarePartition (int a[],int p, int r) 
{
    int x=a[p],i=p-1,j=r+1;
    while (true) 
    {
        while (a[j] <= x) j--; 
        while (a[i] >= x) i++;
        if  (i < j) swap(a[i],a[j]);
        else return j;
    }
}