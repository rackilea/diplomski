public class Test{
    public static void main(String... args){

        String endsWithNewline = "test\n";
        String substring = endsWithNewline.substring(4);

        System.out.println(substring.equals("\t")); //false
        System.out.println(substring.equals(" ")); //false
        System.out.println(substring.equals("\n")); //true
    }
}