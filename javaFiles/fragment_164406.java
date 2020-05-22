public class myClass implements ISet{
   ArrayList<Integer> mySet;
   public myClass(){
      mySet = new ArrayList<Integer>();
    }

   public boolean isSubsetOf(ISet x){
      //you now have to get what type of object x is
      // it is obviously implementing ISet therefore it most probably be myClass.
      //So when you typecast the object it should typecast to myClass.
      ArrayList<Integer> param = (ArrayList<Integer>)( ((myClass)x).mySet );
      return param.containsAll(mySet)
    }
}