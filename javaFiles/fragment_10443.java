int previousRandomNumber = pick();

for (int i = 0; i < 10; i++) {
    int otherRandomNumber = pick();

    if (otherRandomNumber > previousRandomNumber) {
        System.out.println(otherRandomNumber);
    }

    previousRandomNumber = otherRandomNumber;
}