public class IteratorInOneScope { 

    private static final int HALF_OF_MEMORY = (int) (Runtime.getRuntime().maxMemory() * 0.5); 

    public static void main(String[] args) { 
        byte[] data = new byte[HALF_OF_MEMORY]; 

        for (byte b : data); // <-- if you comment this line - the application finished successfully 
        data = null; // this expects to discard reference -> allow to release the memory 

        byte[] data2 = new byte[HALF_OF_MEMORY]; // the memory can't be allocated second time, if the "for" loop statement above is used 

        System.out.println("Success"); 
    } 
}