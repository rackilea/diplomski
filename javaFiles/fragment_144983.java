public static void main(String[] args) {
    int i = 1;
    while (i < 9) {
        String s = exampleWord();
        if ("cat".equals(s) || "dog".equals(s)) {
            System.out.println(s); 
            i++;
        }
    }
}