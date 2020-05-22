for(i=a;i<=b;i++)
    {
        x=i;
        s=0;
        while(x>0)
        {
            r=x%10;
            fact=1;
            for(k=1;k<=r;k++)
            {
                fact=fact*k;
            }
            s=s+fact;
            x=x/10;
        }
        if(s==i)
        System.out.print(i+"  ");
    }