if(i%rand == 0 && rand != hold1)
{
   num1 = true;
   hold1 = rand;
}

if(i%rand == 0 && num1 && rand*hold1 == i)
{
   num2 = true;
}