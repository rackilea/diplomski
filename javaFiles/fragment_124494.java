public void delete(int ID)
{
    testArray = searchArray(ID);   //method used to search array for specified ID

    // do things on the element that is returned from searchArray().
    toolArray[testArray].setQuality(0);
    toolArray[testArray].setToolName("");
    toolArray[testArray].setID(0);
    toolArray[testArray].setNumberInStock(0);
    toolArray[testArray].setPrice(0.0);

    // shift the rest.
    for (index = testArray + 1; index < toolArray.length; index++)
    {
        toolArray[index - 1] = toolArray[index];
    }

    // now toolArray[toolArray.length - 2] and toolArray[toolArray.length - 1]
    //points to the same object. Let's empty the last cell of the array
    toolArray[toolArray.length - 1] = null;
}//end delete