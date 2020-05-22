public boolean equals(Object o) {
    if (o instanceof SparseMatrix<?>) { 
        SparseMatrix that = (SparseMatrix)o;  // <-- downcast
        if (this.xSize != that.xSize ||
                this.ySize != that.ySize)
            return false;
    }
    return false;
}