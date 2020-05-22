outerRow:
for (int or = 0; or <= a.length - b.length; or++) {
    outerCol:
    for (int oc = 0; oc <= a[or].length - b[0].length; oc++) {
        for (int ir = 0; ir < b.length; ir++)
            for (int ic = 0; ic < b[ir].length; ic++)
                if (a[or + ir][oc + ic] != b[ir][ic])
                    continue outerCol;
        System.out.println("Submatrix found at row " + or + ", col " + oc);
        break outerRow;
    }
}