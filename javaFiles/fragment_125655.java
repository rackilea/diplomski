private void setPosition (Grid myGrid) {
    boolean counter = false;

    while (!counter) {
        System.out.println("Give a position, from 0 to " + (myGrid.getColumnCount() - 1) + " : >");
        x = Integer.parseInt(input.nextLine());
    }
}