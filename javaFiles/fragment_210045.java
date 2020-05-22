public static void printList(List<String[]> arrayList) {
    for (String[] currLine : arrayList) {
        for (String currString : currLine) {
            System.out.print(currString + " ");
        }
        System.out.println();
    }
}