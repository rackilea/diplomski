long realerNumber = Math.round(realNumber);
// first guess
long guess = scanner.nextLong();
while (guess != realerNumber) {
    System.out.println("Try Again...");
    // guess again
    guess = scanner.nextInt();
}

System.out.println("You Win!");