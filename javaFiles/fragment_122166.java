public class RevString {
    public static void main(String[] args) {
        Reverse("Canyon");        
    }

    public static void Reverse (String str) {
        int len = str.length();
        String rev="";

        for (int i = 0; i < len; i++) {
            rev = str.charAt(i) + rev;
        }
        System.out.println(rev);    
    }
}