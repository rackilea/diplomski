public boolean checkDay() 
{   

    for(int i = 0; i < isBusy.length; i++)
    {
        if(isBusy[i])
        {
         return true;
        }       
    }
    return false;
}

This method is not correct, see, at the description you said: