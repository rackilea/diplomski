public class Thing
{
   private final int x;
   private final int y;
   private final int z;

   @JsonCreator
   public Thing(String strThing)
   {
       // parse strThing which is in some arbitrary format to set x, y and z
   }

   @Override
   @JsonValue
   public String toString()
   {
       // return a string representation of thing
       // (same format as that parsed by the constructor)
   }

   @Override
   public boolean equals(Object obj) ...

   @Override
   public int hashCode() ...

}