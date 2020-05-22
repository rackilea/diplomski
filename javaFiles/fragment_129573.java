public void display() {
    Range cursor = getLink();
    while (cursor != null) {
        System.out.print(cursor.getData() + " ");
        cursor = cursor.getLink();
    }
    System.out.println("");
}