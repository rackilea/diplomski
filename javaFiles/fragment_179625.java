int number = 15;
int count = 2;
boolean prime = true;


for (int i = count; i <= number/2; i++ ) {

   if (number % i == 0) {
      prime = false;
  }
}


if (prime == true)
{
    System.out.println("Number is prime");
}
else
{
    System.out.println("number is not prime");
}