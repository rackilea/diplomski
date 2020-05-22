public void attack(Player source, Player target) {
    Random random = new Random();
    int damage = random.nextInt(26) - 1;
    if(damage >= 0 && damage <= 15) {
        target.health -= damage;
        System.out.printf("%s attacked %s and %s's health is now %d.", source.name, target.name, target.name, target.health);
    } else if(damage > 15) {
        System.out.printf("%s attacked %s and missed.", source.name, target.name);
    }
}