for(int i=1; i<=number; i++)
{
    if(number%i==0)
    {
        nums[i-1] = i-1;
        cont++;
    }//if         
}//for