public static void main(String[] args) {
    String s = "<pre><font size=\"7\"><strong>Some text here\n\n</strong></font><strong>";

    String o = "";
    boolean append = true;
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '<')
            append = false;

        if (append)
            o += s.charAt(i);

        if (s.charAt(i) == '>')
            append = true;
    }

    System.out.println(o);
}