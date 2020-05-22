public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + Double.hashCode(keyRow);
    result = prime * result + Double.hashCode(keyCol);
    result = prime * result + Double.hashCode(valRow);
    result = prime * result + Double.hashCode(valCol);
    return result;
}