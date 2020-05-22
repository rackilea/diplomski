int n=5;
        for(int i=1;i<=n;i++)
        {        
            for(int j=1;j<=n;j++)
            {   
                if(i<j) {     
                   System.out.print(j-i);
                } else {     
                   System.out.print("*");
                } 
            }
            System.out.println(); 
        }