public boolean assign(int quality, String name, int id, int numInStock, double price)
{
    try {
        setQuality(quality);
        setToolName(name);
        setID(id);
        setNumberInStock(numInStock);
        setPrice(price);
    } catch (IllegalArgumentException iae) {
        return false;
    }
    return true;
}