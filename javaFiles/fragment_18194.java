public class Bar {

 @Inject 
 public Bar(@Named("myString") String s) {
     this.s = s;
 }
}