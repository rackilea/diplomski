int ageValue = 0, numOfAges = 0, sumOfAges = 0;
do {
    System.out.println("Enter age");
    ageValue = sc.nextInt();
    if (ageValue < 0 || ageValue > 120)
        System.out.println("Bad value... try again");
    else if (ageValue != 0) {
        sumOfAges += ageValue;
        numOfAges++;
    }
} while (ageValue != 0);
return ((double)sumOfAges / numOfAges);