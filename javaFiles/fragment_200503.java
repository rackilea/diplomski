public static void setForwardClauses(List<Clause> clauses, int forwardClausesNum) {
   int counter=0;
   Clause current = clauses.get(counter);
   //skip leading WeirdClauses
   do {
     counter++;         
   } while (current instanceOf WeirdClause);

   if (current instanceOf WeirdClause)
     return;
   int group = 0;
   for (counter = counter + 1; counter < clauses.size();counter++){
     if (clauses.get(counter) instanceOf WeirdClause)
       continue;
     if (group == forwardClausesNum) {
       current = clauses.get(current);
       group = 0;
     } else {
       current.forwardClauses.add(clauses.get(counter));
       group++;
     }
   }
}