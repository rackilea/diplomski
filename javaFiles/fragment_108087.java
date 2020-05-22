public boolean exists(int number, int[] array) {
    if (number == -1)
        return true; 

    for (int i=0; i<array.length; i++) {
        if (number == array[i])
            return true;
    }
    return false;
}