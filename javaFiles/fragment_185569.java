int searchForFalses(boolean[] array, int k) {
    for (int n = 0; n < array.length; n += k) {
        if (!array[n])) {
            int start = n;
            while (start >= 0 && !array[start])
                start--;
            int end = n;
            while (end < array.length && !array[end])
                if (end - start >= k)
                    return start;
                else
                    end++;
        }
    }
    return -1;
}