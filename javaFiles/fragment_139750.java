// 5 is the largest

public int getSmallestBox(int boxsize,ArrayList<BoxItems> items)
{
    if(productsFit(boxsize -1)!= null)
    {
        return getSmallestBox(boxsize -1, items)
    }
    else
        return boxsize;
}