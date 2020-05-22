String [] makeItANegativeArray( String [] inputArray ) 
{
for(int i = 0; i < inputArray.Length; i++)
{
    if (inputArray[i].equals("yes"))
    {
        inputArray[i] = "no";
    }
}
return inputArray;
}