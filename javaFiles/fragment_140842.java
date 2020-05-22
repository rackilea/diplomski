public Candy(String n, int cal, double p, double wG)
{
   name = n;
   calories = cal;
   price = p;
   weightGrams = wG;
   // Initialize wammy here.
   wammy = pricePerHundredGrams(price, weightGrams);
}