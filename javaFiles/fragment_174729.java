public interface Weapon{
   public int damage();
   public int range();
   public String name();
   public int rateOfFire();
   public String[] applicableOperators();
   default public void getSpecs() {
       //this is the method in which I have a question
       System.out.printf("Name: %s\nDamage: %d\n Rate of Fire: %d\n"
                 + "Range: %d\n", name(), damage(), rateOfFire(), range());
       for(int arrayCount = 0; arrayCount < applicableOperators().length; arrayCount++){
              System.out.printf("%s\n", applicableOperators()[arrayCount]);
          }
   }
}