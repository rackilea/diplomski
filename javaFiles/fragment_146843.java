void setEntry(int i, int j, in value)
{
    matrix[i][j] = value;
    minimum = Math.min(value, minimum);
    maximum = Math.max(value, maximum);
}