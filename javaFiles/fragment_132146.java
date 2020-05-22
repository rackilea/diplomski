public static void main(String[] args) {
    String s = "=== Etiam ===\neu\nmagna\nsit\namet\norci\nrutrum\nfeugiat\n\n=== Nunc ===\nurna\nlorem,\negestas\net\nvarius\nfermentum,\nconsectetur\nsed\nmauris\n";

    long start = System.currentTimeMillis();
    for (int i = 0; i < 100000; i++)
        replaceAllNoRegex(s);

    System.out.println("Tokens: " + (System.currentTimeMillis()-start));

    start = System.currentTimeMillis();
    for (int i = 0; i < 100000; i++)
        replaceAllIndex(s);

    System.out.println("Index: " + (System.currentTimeMillis()-start));

    start = System.currentTimeMillis();
    for (int i = 0; i < 100000; i++)
        s.replaceAll("(?m)^(=.*?=)$", "$1\n_");

    System.out.println("Regex: " + (System.currentTimeMillis()-start));
}

public static String replaceAllNoRegex(String s) {
    StringTokenizer st = new StringTokenizer(s,"\n");
    StringBuilder sb = new StringBuilder();
    String next;
    while (st.hasMoreElements()) {
        next = (String) st.nextElement();
        sb.append(next);
        if (next.startsWith("=") && next.endsWith("=")) {
            sb.append("\n_");
        }
        sb.append("\n");
    }
    return sb.toString();
}

public static String replaceAllIndex(String s) {
    int index = 0, indexEnd, indexStart = 0;
    StringBuilder sb = new StringBuilder();

    while (index == 0 || (index = s.indexOf("\n=", index)) != -1) {
        indexEnd = s.indexOf("\n",index+2);
        if (indexEnd != -1 && s.charAt(indexEnd-1) == '=') {
            sb.append(s.substring(indexStart,indexEnd));
            sb.append("\n_\n");
            indexStart = indexEnd + 1;
        }
        index = indexEnd+1;
    }
    sb.append(s.substring(indexStart));
    return sb.toString();
}