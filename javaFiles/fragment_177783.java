public class Sample_3 {
   public <T> List<T> testReturn(T t) {
    List<T> list = new ArrayList<T> ();
    list.add(t);
    return list;
   }

   public static void main(String a[]) {
    String s = "Gunjan";
    // this is wrong - the Sample_3 class is not generic. It does not get a generic type parameter.
    Sample_3 sample = new Sample_3<String>();
    // this is also wrong. Since the method is generic the "T" you get is the same as the "T" that 
    // goes into the method. Here your String output type does not match the input type of the method,
    // which you've set here as a Sample_3 object
    List<String> list =(List<String>) sample.testReturn(sample);

}