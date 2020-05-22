public class Test{
    public static void main(String... args){
        System.out.println("\t".equals("\n")); //false
        System.out.println(" ".equals("\n")); //false
        System.out.println("\n".equals("\n")); //true
    }
}