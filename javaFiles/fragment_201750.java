public class Player {
    private int playerHealth;
    private int playerDamage;

    public void attack(Player target) {
        target.playerHealth -= this.playerDamage;
    }

    public static void main(String[] args) {
        Player foo = new Player();
        foo.playerHealth = 10;
        foo.playerDamage = 1;

        Player bar = new Player();
        bar.playerHealth = 10;
        bar.playerDamage = 1;

        foo.attack(bar);
        foo.attack(bar);

        System.out.println(bar.playerHealth); // will print 8
    }
}