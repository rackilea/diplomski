private Vector globalbest(Vector allpop){
   allpop = allPopulation;
   Vector global =null;
   double m1 =(fitness((Vector) allpop.get(1)));
   double m2 =(fitness((Vector) allpop.get(0)));
   int i1 = Double.compare(m1,m2); // if i1 is positive then the first is greater 
   if( i1 > 0 )
      global = (Vector) allpop.get(1); 
   else
      global = (Vector) allpop.get(0); 
   for(int i = 1;i<allPopulation.size()-1;i++)
   {
       m1 = (fitness((Vector) allpop.get(i)));
       double globalfitness = (fitness((Vector) global));
       int i1 = Double.compare(m1,globalfitness); //
       if( i1 > 0 )
           global = (Vector) allpop.get(i);  
   }
   return global;
}