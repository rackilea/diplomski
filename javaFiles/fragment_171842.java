int count = 0;
int chance = rng.nextInt((100)+1);
while (choice != chance) {
    System.out.println(chance);
    chance = rng.nextInt((100)+1);
    count++;
}