void swap(int a, int b)
{
    int temp = a;
    a = b;
    b = temp;
    // a and b are copies of the original values.
    // The changes we made here won't be visible to the caller.
}