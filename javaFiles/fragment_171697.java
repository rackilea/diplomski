count = annualSales;//initial value
for (int i = 0; i < 10; i++)
{
    count = count + 5000;//increment it by 5000 every iteration
    count2 = count * .03 * 1.25;//recalcualte count2
    System.out.println(count + " | " + count2 );
}