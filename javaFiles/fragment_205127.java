int dim1 = (int)args[0];
int dim2 = (int)args[1];

for (int i = 0; i < dim1; i++)
   for (int j = 0; j < dim2; j++)
       a[i][j] = args[2 + (i * dim1 + j)];