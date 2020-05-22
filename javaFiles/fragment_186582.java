public static void main(String[]Args)
{
    double chargeNumber = 0;
    chargeAccountModi object1 = new chargeAccountModi();

    try
    {
        System.out.println(" The search result is : " + object1.sequentialSearch(chargeNumber));
    }
    catch (IOException ioe)
    {
        System.out.println("Exception!!!");
        ioe.printStackTrace();
    }

}