int dim = a.length;
assert a[0].length == dim; // quadratic

for (int i = 0; i < a.length; ++i)
    for (int j = 0; j < i; ++j)
         a[i][j] = a[j][i];