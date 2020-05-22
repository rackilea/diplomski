public static void isSorted(int[] list) {
    String s = "The list is sorted";
    String nS = "The list is not sorted.";
    System.out.print("The list has ");
    System.out.print(list.length);
    System.out.print(" integers ");
    for (int i = 0; i < list.length; i++) {
        System.out.print(list[i] + " ");
    }

    for (int i = 0; i < (list.length - 1); i++) {
        if (list[i] > list[i + 1]) {
            System.out.println(nS);    // changed here
            return;
        }
    }
    System.out.println(s);             // and changed here
    // no return required here
}