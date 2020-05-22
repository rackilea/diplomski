import java.util.List;
  import java.util.ArrayList;  
  import java.util.Collections;

  public abstract class Feline implements Comparable
  {
       protected double weight; 

       protected abstract void whoAmI();

       public void compareTo(Feline other){
          new Double(this.weight).compareTo(new Double(other.weight));
       }

       public static void main(String[] args){
          Cage c = new Cage();

          Feline l = new Lion(400.0);
          Feline t = new Tiger(555.0);

          c.addFeline(l);
          c.addFeline(t);

          for(Feline f : c.getCage()){
             f.whoAmI();
          }
       }
   }

    class Tiger extends Feline 
    {
       public Tiger(double weight){
          super(weight);
       }      

       protected void whoAmI() {
          System.out.println("I'm a Tiger");
       }
    }

    class Lion extends Feline 
    {
       public Lion(double weight){
          super(weight);
       }

       protected void whoAmI() {
          System.out.println("I'm a Lion");
       }
    }

    class Cage
    {
        private List<Feline> felines; 

        public Cage(){
           this.felines = new ArrayList<>();
        }

        public void addFeline(Feline f){ 
           this.felines.add(f); 
        }

        public List<Feline> getCage(){
           return this.felines;
        }

        public void sort(){
           Collections.sort(this.felines);
        }
    }