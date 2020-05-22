int counter = 1;
System.out.println("Printing prime numbers");

for (int numer = 2; counter <= 100; numer++){
    if (checkforprime(numer)) {
        System.out.println(numer);
        counter++;
    }

}