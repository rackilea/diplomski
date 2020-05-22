public class InvinciblePlayer extends Player {
  @Override
  protected int computeDamage(int strikePower){
    System.out.println("Mwa-ha-ha-ha!!! I am invincible!!! ... Almost");
    return 0;
  }
}