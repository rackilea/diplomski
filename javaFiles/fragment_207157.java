while(whereWeAre != currentSize && weFoundIt == false)
     {
        if (theList[whereWeAre]!=null)
        {
            currClass = theList[whereWeAre].getClassName();
            if(currClass.equals(paramClass))
            {
               theList.remove(whereWeAre);
               weFoundIt = true;
            }
            else
            {
               whereWeAre++;
            }
        }
        else
        {
            whereWeAre++;
        }
     }