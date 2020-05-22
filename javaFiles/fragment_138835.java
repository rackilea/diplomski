i = 0;
j = 0;
while(temp>0 && i<n && j<n)
{
    sum=a[i][j]+sum;
    temp=temp-1;
    i++;j++;
}

i = 0;
while(temp2>0 && i<n && k>=0)
{
    sum1=a[i][k]+sum1;
    temp2=temp2-1;
    i++; k--;
}