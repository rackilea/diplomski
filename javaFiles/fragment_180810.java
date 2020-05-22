public class Examples  {
    public static void main(String[] args) {
        String d = "DIAGONALLY";
        String s = "";

        for (int i = 0; i < d.length(); i++) {
            System.out.printf("%s%s\n", s, d.charAt(i));
            if (i < 5)
                s = s + " ";
            else
                s = s.substring(1);
        }
    }
}