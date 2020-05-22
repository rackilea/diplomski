public class HelloWorld {

     public static void main(String []args){
        long s = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 10000; j++) {
                System.out.flush();
            }
        }

        System.out.println((System.currentTimeMillis() - s));  // 1097
     }
}