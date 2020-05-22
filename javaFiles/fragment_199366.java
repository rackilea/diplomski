public void printall() {
    System.out.print(data[0]);
    for (int i = 1; i < data.length; i++) {
        System.out.printf(", %d", data[i]);
    }
    System.out.println();
}