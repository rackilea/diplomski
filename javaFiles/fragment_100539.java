for (int i = 0, j = 0, k = 0; i < x.length || j < y.length; k++){
    if (j==y.length || (i!=x.length && x[i].compareTo(y[j]) <= 0)
        result[k] = x[i++];
    else
        result[k] = y[j++];
}