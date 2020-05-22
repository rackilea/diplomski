// See if we've got five eights in any direction:
for (int r = 0 ; r != intersections.length ; r++) {
    for (int c = 0 ; c != intersections[r].length ; c++) {
        if (checkRow(r, c, 0, 1, 5, 8)) {
            System.out.println("Horizontal, starting at "+r+" " +c);
        }
        if (checkRow(r, c, 1, 0, 5, 8)) {
            System.out.println("Vertical, starting at "+r+" " +c);
        }
        if (checkRow(r, c, 1, 1, 5, 8)) {
            System.out.println("Diagonal descending right, starting at "+r+" " +c);
        }
        if (checkRow(r, c, 1, -1, 5, 8)) {
            System.out.println("Diagonal descending left, starting at "+r+" " +c);
        }
    }
}