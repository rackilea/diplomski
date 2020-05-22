public class Meat extends Food {
   public Meat() {
     super("Meat");
   }

    @Override
    public String getName() {
      return super.getName + "(but don't abuse it)";
   }
}