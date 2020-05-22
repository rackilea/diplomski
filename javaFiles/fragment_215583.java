void add10k() {
    int oldValue, newValue;
    do {
        oldValue = count;  // get the current value
        newValue = oldValue + 1; // calculate the new value based on the old
    } while (oldValue != cas(oldValue, newValue)); // Do a compare and swap - if the oldValue is still the current value, change it to the newValue, otherwise not.
}