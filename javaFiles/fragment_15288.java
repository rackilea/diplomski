// remove entirely this constructor, you will not need it
public Question2(int trow, int tcol, int[][] m) {

    this.row = trow;
    this.col = tcol;
    this.matrix = m;
}

// but use only this one
public Question2(int trow, int tcol) {
    this.row = trow;
    this.col = tcol;
    this.matrix = new int[trow,tcol];// just make sure it will initialize `matrix`
}