public class Countries
{
   private final Map<String, Set<String>> countries = new HashMap<String, Set<String>>();

   public void addCountry(@NotNull String name) {
      addNeighbourPair(name, null);
   }

   public void addNeighbourPair(@NotNull String first, String second) {
      if (!hasCountry(first)) {
         countries.put(first, new HashSet<String>());
      }
      if (second != null) {
         if (!hasCountry(second)) {
            countries.put(second, new HashSet<String>());
         }
         countries.get(first).add(second);
         countries.get(second).add(first);
      }
   }

   public boolean hasCountry(String name) {
      return countries.containsKey(name);
   }

   public Set<String> getNeighbours(String name) {
      return countries.get(name);
   }

   /* 
    * the correctness of this loader is validated only with respect 
    * to using the Countries class :) 
    */
   public static Countries fromFile(String borders) {
      Countries countries = new Countries();

      Scanner bordersload = new Scanner(new File(borders));
      while (bordersload.hasNextLine()) {
         String line = bordersload.nextLine();
         String[] values=line.split(" : |:|: | :");
         String key=String.valueOf(values[0]);
         String key1=String.valueOf(values[1]);

         countries.addNeighbourPair(key, key1);
      }
      bordersload.close();
      return countries;
   }
}