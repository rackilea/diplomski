int count2 = 0;     
    for(int i = lowerbound; i<=upperbound; i++)
    {
        int temp = Math.abs(i); //make positive. No negative log 
        if(temp==0) //beware the log(0) trap 
            continue;
        int length = (int)(Math.log10(temp)+1); //count digits
        for(int j = length -1; j>=0 ; j--)  //inspect digit for digit
        {
            if(temp % 10 == 1)
            {
                count2 ++;
            }
            temp = temp / 10;
        }
    }