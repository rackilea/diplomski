boolean flag=true;
        for(int i=2;i<=n/2;i++)
        {
            if(n%i==0)
            {
                flag=false;
                break;
            }
            else
                flag=true;
        }
        if(flag)
        {
            System.out.println("given number is prime");
        }
        else
        {
            System.out.println("given number is not prime");
        }