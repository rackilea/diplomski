for (soldBoxIndex = 0; soldBoxIndex < numSaleSlips; soldBoxIndex++)
{
    if (soldBoxIndex % 2 != 0
    {
        String soldBoxString;


        soldBoxString = input.readLine(); //reads in value and assigns/re-assigns
        soldBox[numSaleSlips] = (int) Double.parseDouble(soldBoxString); //type-casted to fit variable type, converts to double, stores in array
        System.out.println(soldBox[soldBoxIndex]);
    }
    else 
    {
        input.readLine(); //read the following line, but ignore its content, effectivly skipping the line
    }

}