public class OccursIn {
    public static void main(String[] args) {
        String pattern = "s*h*l";
        String str = "love hss";
        if (occursIn(pattern, str)) {
            System.out.println(pattern + " occurs in " + str);
        } else {
            System.out.println(pattern + " does not occurs in " + str);
        }
    }

    public static boolean occursIn(String pattern, String str) {
        for (int i = 0; i < pattern.length(); i++) {
            String c = pattern.substring(i, i + 1);
            if (!"*".equalsIgnoreCase(c) && !str.contains(c)) {
                return false;
            }
        }
        return true;
    }
}