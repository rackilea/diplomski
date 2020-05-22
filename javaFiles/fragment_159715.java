public static void main(String[] args) {

    String star = "*";
    String for_slash = "/";
    String back_slash = "\\";
    String space = " ";

    int n = 4;
    for (int i = 0; i < n; i++) {
        String line = "";
        int d = i % n;
        for (int l = n - 1; l > 0; l--) {
            line += ((l < (d + 1)) ? for_slash : space) + space;
        }
        line += star;
        for (int l = 0; l < n - 1; l++) {
            line += space + ((l < d) ? back_slash : space);
        }
        System.out.println(line);
    }
    for (int i = 0; i < n; i++) {
        String line = "";
        int d = i % n;
        for (int l = 0; l < n - 1; l++) {
            line += ((l > (d - 1)) ? back_slash : space) + space;
        }
        line += star;
        for (int l = n - 1; l > 0 ; l--) {
            line += space + ((d < l) ? for_slash : space);
        }
        System.out.println(line);
    }
}