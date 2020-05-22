public class Main {
    public static void main(String[] args) {
        String s = "hello world";
        String rep = s.replaceAll("[a-z]", " ");
        int F = s.length();
        int G = 3;

        System.out.println(s);
        for(int i = 1; i<s.length()-1; i++, F--, G++)
            System.out.println(s.charAt(0) + rep.substring(F) + s.charAt(i) +
                rep.substring(G) + s.charAt(s.length()-1));
        System.out.println(s);
    }
}