class SparseMatrix {
    ColumnNode head;
    int dimx, dimy;
    // other members
}

class ColumnNode {
    int colNum;
    RowNode head;
    ColumnNode next;
}

class RowNode {
    int rowNum;
    double value;
    RowNode next;
}