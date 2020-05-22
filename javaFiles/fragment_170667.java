class Hunter {
   void hunt(){
       System.out.println("i'm hunting...");
   }
}

interface CanHunt{
   Hunter getHunter();
}

class Dog extends Mammals implements CanHunt{
   ...
   Hunter hunter = new Hunter();

   @Override
   Hunter getHunter(){
       return hunter;
   }      
   ...
}


class Lion extends Mammals implements CanHunt{
   ...
   Hunter hunter = new Hunter();

   @Override
   Hunter getHunter(){
       return hunter;
   }      
   ...
}