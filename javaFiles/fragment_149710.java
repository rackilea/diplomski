public void shiftRight() 
{
    //make temp variable to hold last element
    int temp = listValues.get(listValues.size()-1); 

    //make a loop to run through the array list
    for(int i = listValues.size()-1; i > 0; i--)
    {
        //set the last element to the value of the 2nd to last element
        listValues.set(i,listValues.get(i-1)); 
    }
    //set the first element to be the last element
    listValues.set(0, temp);     
}