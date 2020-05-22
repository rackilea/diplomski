for(int i=1; i<numItems; i++)
{
    int count = 0;
    bool found = false;
    do {
        int m=rand.nextInt(numItems);
        count++;
        for(int j=0; j<i; j++)
        {
            if(m==permutation[j])
            {                   
                found = true;
                break;
            }
        } 
    } while (found);
    permutation[i]=m;
    numAttempts[i]=count;    
}