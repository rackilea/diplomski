public FrameArray( String frame, int[] unitsArray, double[] priceArray, double product )
{
    frameInventory = frame;
    units = unitsArray;
    price = priceArray;
    this.product = weightedProduct(unitsArray, priceArray);
}