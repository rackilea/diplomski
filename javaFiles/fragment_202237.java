public class TestFreeMemory {

 static void allocateSomeMemory(){
  long[][] array = new long[400][400];
 }

    public static void main(String ... args){

        Runtime rt = Runtime.getRuntime();

        allocateSomeMemory(); // once we leave, our array is not reachable anymore 
        System.out.println("Free Memory (Before GC): " + rt.freeMemory());     
        rt.gc();
        System.out.println("Free Memory (After GC): " + rt.freeMemory());

        String a = new String("A");
        for(int i = 0; i < 100; i++){
         a+="B";
        }

        System.out.println("Free Memory (After String Creation): " + rt.freeMemory());
        // Less free memory expected.
    }

}