isPrime = true;
for (int i =2; i<= input/2; i++) //Determine if prime
{
    if (input % i == 0)
        isPrime = false;

    if (input > max)
    {
        max = input;
    }
    if (input < min)
    {
        min = input;
    }
    sum += input;
    count = count + 1;
    average = sum/count;
    break;
}

if (isPrime)
    System.out.println("The number " + input + " is a prime number");
else
    System.out.println("The number " + input + " is not a prime number");