while (n % i == 0)
{
  System.out.println(i);
  n = n / i;
  // i = 2; /* Ouch */
}