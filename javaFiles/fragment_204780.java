public class Word {
    public static void main(String args[]) {
        String rev = "This is a string";
        char[] a = new char[rev.length()];

        int i = 0;
        for (; i < a.length; i++) {
            a[i] = rev.charAt(i);
            if (rev.charAt(i) == ' ' && i + 1 < a.length) {
                if (rev.charAt(i+1) >= 'a' && rev.charAt(i+1) <= 'z') {
                    a[i + 1] = (char)(rev.charAt(i + 1) - 32);
                    i++;
                }
            }
        }  
        String title = new String(a);
        System.out.print(title);
    }
}