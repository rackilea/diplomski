do {
    if (sum2 == 7) {
        System.out.println("You rolled: " + sum2);
        System.out.println("You lose");
    }
    if (sum2 == sum) {
        System.out.println("You rolled: " + sum2);
        System.out.println("You win!!!");
    }
}
while (sum2 != sum || sum2 != 7); // Condition never changes