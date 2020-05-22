Object[][] combineArrays(Object[] assd, Object[] eventy, Object[] assFT)
{
    Object[][] outputArray = new Object[3][];
    outputArray[0] = new Object[assd.length];
    outputArray[1] = new Object[eventy.length];
    outputArray[2] = new Object[assFT.length];

    for (int i = 0; i < assd.length; i++)
    {
        outputArray[i][0] = assd[i];
    }

    for (int i = 0; i < assd.length; i++)
    {
        outputArray[i][1] = eventy[i];
    }

    for (int i = 0; i < assd.length; i++)
    {
        outputArray[i][2] = assFT[i];
    }

    return outputArray;
}