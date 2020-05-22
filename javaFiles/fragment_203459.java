int rollCt = 0;  // Number of rolls made.
   do {
      dice.roll();
      rollCt++;
   } while ( dice.getDie1() + dice.getDie2() != N );
   return rollCt;