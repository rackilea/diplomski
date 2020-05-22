for(int p=0;p<num.length-1;p++)
    {
        if(m==num[p])
        {
            num[p]=num[p+1];

            // Add this line
            m = num[p];
        }
    }