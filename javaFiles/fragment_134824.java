static void swag(int s, int l)
{   int sum = 0;int d,temp, fax, i;
    for(i=s;i<=l;i++)
    {
        sum=0;
        temp = i;
        while(temp>0)
        {
            d=temp%10;
            fax = fact(d);
            sum += fax;
            temp/=10;
        }
     if(sum==i)
        System.out.println(i+" is special");
    }
}