public int population(int days, int startingOrganisms, double dailyIncrease) {
      if (days <= 1) {
         System.out.print(days + " " + startingOrganisms);
         //no increase, finish condition
         return startingOrganisms;
      } else {
         // we need to find the population of yesterday to know how much organisms exist today
         int populationYesterday = population(days - 1, startingOrganisms, dailyIncrease);
         int populationToday = populationYesterday + (populationYesterday * dailyIncrease / 100);

         System.out.print(days + " " + populationToday);
         return populationToday;
      }
   }