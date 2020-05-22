public interface CausesDamage ()
{
    public double damage ();
}

public abstact class CharacterType implements CausesDamage ()
{
   private int _level;
   ...
   public abstract double damage ();
   ...
   public int getLevel ()
   {
       return _level;
   }
}

public class Warrior extends CharacteType ()
{
   public static final int MIN_DAMAGE = ..;
   public static final int MAX_DAMAGE = ..;
   ...
   private Random rand = new Random();
   ...
   public double damage ()
   {
       return rand.nextInt(MAX_DAMAGE-MIN_DAMAGE+1)+MIN_DAMAGE + getLevel()*1.9;
   }
}