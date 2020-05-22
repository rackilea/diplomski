public class Q {

    public static void main(String[] args) {

        String s1 = "Hello";
        String s2, s3;

        s2 = s1.substring(0, s1.length()/2);
        s3 = s1.substring(s1.length()/2);

        System.out.println(s3+s2);
    }
}