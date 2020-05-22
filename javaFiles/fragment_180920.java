if(n1 != null && n2 != null) {
        if(n1.value < n2.value) {
            result = n1;
            result.next = merge(n1.next, n2);
        } else {
            result = n2;
            result.next = merge(n1, n2.next);
        }

} else if (n1 != null) {  
    result = n1;  // Add all the elements of `n1` to `result`
} else if (n2 != null) {
    result = n2;  // Add all the elements of `n2` to `result`
}