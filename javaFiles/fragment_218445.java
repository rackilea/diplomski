void QuickSort(int arr[], int left, int right)
{
    // create auxiliary stack
    int stack[] = new int[right-l+1];

    // initialize top of stack
    int top = -1;

    // push initial values in the stack
    stack[++top] = left;
    stack[++top] = right;

    // keep popping elements until stack is not empty
    while (top >= 0)
    {
        // pop right and l
        right = stack[top--];
        left = stack[top--];

        // set pivot element at it's proper position
        int p = partition(arr, left, right);

        // If there are elements on left side of pivot,
        // then push left side to stack
        if ( p-1 > left )
        {
            stack[ ++top ] = l;
            stack[ ++top ] = p - 1;
        }

        // If there are elements on right side of pivot,
        // then push right side to stack
        if ( p+1 < right )
        {
            stack[ ++top ] = p + 1;
            stack[ ++top ] = right;
        }
   }
}