public String toString()
{
    StringBuilder result = new StringBuilder();
    result.append("Shop [ name = "+name+" ");

    for(Product p : products)
    {
        result.append("Product name"+" = "+p.getName()+", "+"Price"+" = "+p.getPrice()+" ");
    }

    result.append("]");
    return result.toString();
}