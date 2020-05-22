int end = array.length;
if (end > 0) {
    int start = 0;
    for (int i = 1; i < end; i++) {
        if (array[i] != array[i - 1] + 1) {
            if (i - start > 1) {
                list.put(start, i - 1);
                System.out.println("i = " + start + " to j = " + (i - 1));
            }
            start = i;
        } 
    }
    if (end - start > 1) {
        list.put(start, end - 1);
        System.out.println("i = " + start + " to j = " + (end - 1));
    }
}