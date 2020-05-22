public int countBunches(int[] myArray)
{   
    int count = 0;
    int lastItem;
    boolean lastItemMatched;

    for(int i = 0; i<myArray.length; i++)
    {
        if(i == 0)
        {
            lastItem = myArray[0];
            lastItemMatched = false;
        }
        else
        {
            if(lastItem == myArray[i])
            {
                if(!lastItemMatched)
                {
                    count++;
                }

                lastItemMatched = true;
            } else {
                lastItemMatched = false;
            }

            lastItem = myArray[i];
        }
    }   

    return count;
}