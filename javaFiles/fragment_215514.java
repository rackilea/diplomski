public static void printList(String[] words, int count) {
    for (int i=0; i < count; i++) {
        if (i > 0) System.out.print(",");
        System.out.print(words[i]);
    }
}