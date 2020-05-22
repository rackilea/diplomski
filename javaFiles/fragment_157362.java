public class ResultGenerator<T> {

     class Possibility
     {
         Possibility(T choice, int chance)
         {
             this.Choice = choice;
             this.Chance = chance;
         }

         public T Choice;
         public int Chance;
         public int RangeMax;
         public int RangeMin;

     }

     private Random r;

     public ResultGenerator(Random r)
     {
         this.r = r;
     }

     public ResultGenerator()
     {
         this.r = new Random();
     }

     private List<Possibility> possibilities = new ArrayList<Possibility>();

     public void AddPossibility(T choice, int chance) {
         possibilities.add(new Possibility(choice, chance));
     }

     public T GetRandomResult() {

         if (possibilities.size() == 0)
             return null;

         //Calculate ranges for possibilities
         int totalChances = 0;
         for (Possibility p : possibilities) {
             p.RangeMin = totalChances;
             p.RangeMax = totalChances + p.Chance;
             totalChances += p.Chance;
         }

         int randomNumber = 1 + r.nextInt(totalChances + 1);

         for(Possibility possibility : possibilities)
         {
             if (randomNumber <= possibility.RangeMax && randomNumber > possibility.RangeMin)
             {
                 return possibility.Choice;
             }
         }

         return null;
     }

}