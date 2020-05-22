public static void print(String s) {
        out.print(s.charAt(0));
        if (s.length() == 1) out.print("\n");
        else {
            if (((s.length()-1) % 3) == 0) out.print(",");
            print(s.substring(1));
        }
}