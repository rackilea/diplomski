public class Main{
    public static void main(String... args){

    Stream.of("12/31/2014", "01-01-2015", "2016")
          .filter(Main::valid())
          .forEach(s->out.println(s));   
   }
   public static Predicate<String> valid(){
     return s->s.length()>0;   
   } 
}