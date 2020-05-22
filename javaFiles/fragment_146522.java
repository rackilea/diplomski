public class Main {

    public static class Projectile
    {
         public Projectile(){
         }

         public Projectile(int i, int i2){
         }
    }

    public static class Bullet extends Projectile
    {
         public Bullet(){
         }

         public Bullet(int i, int i2){
         }
    }

    public static class Rocket extends Projectile
    {
         public Rocket(){
         }

         public Rocket(int i, int i2){
         }
    }

    public static class Weapon
    {
         public Weapon(){
         }

         //This method is wrong and is where i need help
         public <E extends Projectile> E fire(Class<E> projectile) {
            try {
                return projectile.getConstructor(int.class, int.class).newInstance(1, 2);
            } catch(Exception e) {
                System.out.println("The class " + projectile.getSimpleName() + " does not have a valid constructor");
                return null;
            }
         }
    }

    public static void main(String[] args) {
        Weapon weapon = new Weapon();
        Projectile p = weapon.fire(Projectile.class);
        Bullet b = weapon.fire(Bullet.class);
        Rocket r = weapon.fire(Rocket.class);
    }
}