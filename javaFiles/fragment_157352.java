public int compareTo(DimensionWritable o) { 
    int c = Double.compare(this.keyRow, o.keyRow);
    if (c != 0) return c;
    c = Double.compare(this.keyCol, o.keyCol);
    if (c != 0) return c;
    c = Double.compare(this.valRow, o.valRow);
    if (c != 0) return c;
    c = Double.compare(this.valCol, o.valCol);
    return c;
}