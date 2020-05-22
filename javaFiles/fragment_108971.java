public class InstrumentedRunner {

   public static void main(String... arg) {
       long start = System.currentTimeMillis();
       new Runner().run();
       long dur = System.currentTimeMillis() - start;
       System.out.format("Runner took %s milliseconds", dur);
   }
}