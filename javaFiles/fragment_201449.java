int number = 13195;
int i = (int)Math.sqrt(number);

do {
    i--;
} while (isPrime(i) && isFactor(number, i) == false);

System.out.println(i);