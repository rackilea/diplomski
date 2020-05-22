for (int i=2; i<n; i++)  
{  
    fib=f1+f2;  
    f1=f2;  
    f2=fib;  
}  

System.out.println( fib );