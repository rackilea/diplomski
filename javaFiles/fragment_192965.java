public static int partition(int left, int right, int pivotPosition) {

    int p = u[pivotPosition];    // pivot

    // Move pivot to the end
    swap(pivotPosition, right);

    int lPt = left - 1;
    int rPt = right;

    while (true) {

        while ((lPt < right) && (u[++lPt] < p));

        while ((rPt > left) && (u[--rPt] > p));

        if (lPt >= rPt) {
            break;
        } else {

            swap(lPt, rPt);
            System.out.println("Swapping " + lPt + " " + rPt);
        }

    }

    // Put pivot in its place
    swap(lPt, right);

    return lPt;
}