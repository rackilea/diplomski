boolean someRowIsSumOfTwoOthers(int n, int [][] A){ 
    int i, j=0;
    int []rowSums=new int[n];
    boolean isTotal = false;
    //This part cut the code into one deminsion
    //Makes it eaiser to work with
    for(int[] b:A)
    {
        for(i=0;i<b.length;i++)
        {
            rowSums[j]+=b[i];
        }
        //useing j as a row incrimenter
        j++;
    }
    //for the value of one row
    int rowVal;
    //for the value of the other two
    for(int x=0;x<n;x++)
    {
        rowVal=rowSums[x];
        //nested forloop to test any of the other rows combinations
        for(int y=0;y<n;y++)
        {
            //check to keep row values from repeating
            if(y==x)
                y++;
            for(int z=0;z<n;z++)
            {
                //check to keep row values from repeating
                while(z==y || z==x)
                    z++;
                if(z>=n)
                    break;
                if(rowVal==rowSums[z]+rowSums[y])
                    return true;
            }
        }
    }