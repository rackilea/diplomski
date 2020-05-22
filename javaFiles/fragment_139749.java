int boxCount = getInitBoxCount(products);

public int getInitBoxCount(ArrayList<BoxItems> items)
{
    if(productsFit(products,sizeLarge) == null)
    {
        ArrayList<BoxItems> temp1 = new ArrayList<BoxItems>();
        ArrayList<BoxItems> temp2 = new ArrayList<BoxItems>();

        for(int x = 0; x < items.length ; x++)
        {
           if(x > items.length/2)
           {
               temp1.add(items.get(x)) 
           }
           else
           {
               temp2.add(items.get(x))
           }
        }
        return getInitBoxCount(temp1) + getInitBoxCount(temp2);
    }
    return 1;
}