public static Product parseStringToProduct(String lineToParse)
{
    Product p=null;
    String[] inputToken = lineToParse.split("/");
    if (inputToken[0].equalsIgnoreCase("Food"))
    {
       p = new Food(inputToken[1], Integer.parseInt(inputToken[2]), Double.parseDouble(inputToken[3]), inputToken[4], Double.parseDouble(inputToken[5]), inputToken[6]);

    }
    else
    {
       p = new Clothing(inputToken[1], Integer.parseInt(inputToken[2]), Double.parseDouble(inputToken[3]), inputToken[4], inputToken[5]);
    }
    return p;
}