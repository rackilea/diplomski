public static int partition(int A[], int left, int right) {
    int pivot, i, j;

    pivot = A[right];
    i = left;
    j = right - 1;

    do {
        // Search for element greater than pivot from left, remember position
        while ( A[i] <= pivot && i < right ) i++;

        // Search for element less than pivot from right, remember positon
        while ( A[j] >= pivot && j > left ) j--;

        // If elements are in the wrong part of the array => swap
        if ( i < j ) swap( A, i, j );

    // Continue until the whole (sub)array has been checked    
    } while ( j > i );

    // Put the pivot element at its final position if possible
    if ( A[i] > pivot )
        swap ( A, i, right );

    // Return the border / position of the pivot element    
    return i;
}