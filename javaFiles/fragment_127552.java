import java.util.HashSet;
import java.util.Set;

public class NewClass 
{
   public static enum Errors
   {
      ERROR_A(1),
      ERROR_B(2),
      ERROR_C(3),
      ERROR_D(2), //duplicate is here!
      ERROR_E(5);

      int m_id;
      Errors(int id)
      {
          m_id = id;
      }

      public int getId()
      {
          return m_id;
      }
   }

   public static void main(String[] args) 
   {
      Set<Integer> usedIds = new HashSet<>();
      for (Errors e : Errors.values()) //iterate over all Error-Enum-Items
      {
          int id = e.getId(); //fetch id from enum-item
          if (usedIds.contains(id)) //check if id was used before
              System.err.println("ID ALREADY USED: " + e.name() + ":" + id);
          else
              usedIds.add(id); //remember new used id here
      }
   }
}