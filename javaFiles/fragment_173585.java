if(number==0)
        return 1; //or 0, it depends on what you want
    else if(number==2)
        return 2;
    else
    {
         if(number%2==0)
             return number*fact(number-1);
         else
         {
             return fact(number-1);
         }
    }