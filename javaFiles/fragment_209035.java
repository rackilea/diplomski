for (int k = 0; k < 2; k++) {
    zar[k] = roll.nextInt(6) + 1; // k loop populates your array.
}
if (zar[0] == zar[1]) {
    System.out.println("Your numbers are : " + zar[0] + " and "
            + zar[1] + "\nYou won! \nYEEEY!!");

} else {
    System.out.println("Your numbers are : " + zar[0] + " and "
            + zar[1] + "\nYou lost, better luck next time!");
}