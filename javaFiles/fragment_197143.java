public boolean isAProduct(String product)
//Returns true if a name has been found otherwise returns false
{
    boolean found = false;
    int counter = 0;

    while (!found && (counter < MAXNUMBEROFPRODUCTS))
    {
        if (product.equalsIgnoreCase(product1.getName()))
        {
            found = true;
        }
        else if (product.equalsIgnoreCase(product2.getName()))
        {
            found = true;                 
        }
        else if (product.equalsIgnoreCase(product3.getName()))
        {
            found = true;                 
        }
        else 
        {
            counter++;
        }            
    }        

    return found;
}//End of method