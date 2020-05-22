int countEven = 0, countOdd = 0, sum = 0;

for(int i= 1; i <= 50; i++){

    if ((i % 7 == 0) && (i % 2 == 1)) {
        System.out.println("This is an odd number that is divisible by 7: " + i);
        countOdd++;
    }

    if ((i % 9 == 0) && (i % 2 == 0)) {
        System.out.println("This is an even number that is divisible by 9: " + i);
        countEven++;
        sum += i;
    }
}

System.out.println("These are " + countOdd " odd numbers thare are divisible by 7 and " + countEven + " even numbers that are divisible by 9.");
System.out.println("Sum of even numbers that are divisible by 9: " + sum);