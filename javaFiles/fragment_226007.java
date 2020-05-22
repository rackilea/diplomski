function insertion_sort(items) {
    while (i=1; i < items length; i++) { // for elements 1 to n
        while (j=i; j >= 0; j--) { // look backward through all previously sorted items
            if (items element at j < items element at j-1) {
                 swap element at j with element at j-1
            } else {
                break out of the loop
            }
        }
    }
}