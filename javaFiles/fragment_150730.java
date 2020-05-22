public static void addSlashes(String str) {
    if (str.isEmpty())
        return;

    System.out.print(str.charAt(0) + "/");
    addSlashes(str.substring(1));
}