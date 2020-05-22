public class Student{
    private String name;
    private int score;
    @Override
    public boolean equals(Object obj){
         if(obj == null)
           return false;
         else if(this==obj)
           return true;
         else 
           return this.hashCode() == ((Student)obj).hashCode();
    }
    @Override
    public int hashCode() {
         return score;
   }
}