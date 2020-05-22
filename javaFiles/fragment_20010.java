public void vsibleModification(int[] a) {
    for (int i = 0; i < a.length; i++) {
        // This change is visible outside of method because I change 
        // the content of a, not the reference
        a[i] = a[i] + 1;  
    }
}

public void nonVisibleModification(int[] a) {
    // Non visible modification because a is reassigned to a new value (reference modification)
    a = new int[2];
    a[0] = 1;
    a[1] = 2;
}