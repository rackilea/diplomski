public class IntegerParameter extends Parameter<Integer> {

     public IntegerParameter(Integer current) {
         // specify a default min/max for the Integer impl
         super(-1, 999, current); 
     }
}