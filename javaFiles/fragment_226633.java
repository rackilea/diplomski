int n = ...;
int dim = ...;

// Raise n to the power of dim: powN = n^dim
long powN = 1;
for (int i = 0; i < dim; ++i) powN *= n;

int[] indices = new int[dim];
for (long i = 0; i < powN; ++i)
{
    // Calculate the indices
    long bigI = i;
    for (int k = 0; k < dim; ++k)
    {
         indices[k] = bigI % n;
         bigI /= n;
    }

    // Now all your indices are stored in indices[]

}