public int[] producto(int num) 
{
    // make a 10-element array
    int a[] = new int[10];

    // fill up the array with products
    for (int i = 0; i < 10; i++)
        a[i] = num * (i + 1);

    return a;
}