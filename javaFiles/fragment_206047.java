for(int g = 0; g < priceArray.size(); g++)
{
    for(int h = 1; h < priceArray.size() - 1; h++)
    {
        int found1 = priceArray.get(h).lastIndexOf('$');
        int found2 = priceArray.get(h+1).lastIndexOf('$');

        String firstPrice = priceArray.get(h);
        String secondPrice = priceArray.get(h+1);

        String first = firstPrice.substring(found1+1);
        String second = secondPrice.substring(found2+1);

        if(Double.parseDouble(first) > Double.parseDouble(second))
        {
            String a = priceArray.get(h);
            String b = priceArray.get(h+1);

            priceArray.set(h,b);
            priceArray.set(h+1, a);
        }
    }
}