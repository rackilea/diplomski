static int sum(int s)
            {
                int n=s;
                 int add=0;
                 while(n%10 > 0)        
                 {
                     add = (n%10) +add;
                     n = n/10;
                     System.out.println("num is "  +n );
                 }

                if(add/10 > 0)
                {
                    System.out.println(add);
                    return sum(add);
                }
                return add;


            }