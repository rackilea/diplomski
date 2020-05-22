for (int a = 0; a < list.length; a++) {
    for (int b = a + 1; b < list.length; b++) {
        for (int c = b + 1; c < list.length; c++) {
            System.out.print(list[a] + ", ");
            System.out.print(list[b] + ", ");
            System.out.println(list[c]);
        }
    }
}