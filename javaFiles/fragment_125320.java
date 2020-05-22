while(true)
{
    result = Math.pow(3, n);
    if(result > 1000)
    {
        break;
    }
    System.out.println(((int)result));
    result = Math.pow(5, n);
    if(result < 1000)
    {
        System.out.println((int)result);
    }          
    n++;
}