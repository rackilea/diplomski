int[] array1 = { 1, 2, 3 };
int[] array2 = { 3, 4, 5 };
int[] merged = new int[array1.length + array2.length];
    int pos = 0,i=0, j;

    Set<Integer> intSet = new HashSet();

    for (i = 0; i < array1.length; i++) {
        if(!intSet.contains(array1[i])) {
        merged[pos] = array1[i];
        intSet.add(Integer.valueOf(i));
        pos++;

        }
    }

    for (j= 0, pos = pos-1; j < array2.length; ) {
        if(!intSet.contains(Integer.valueOf(array2[j]))) {
            merged[pos] = array2[j];
            intSet.add(Integer.valueOf(i));
            pos++;
            j++;
        }
    }
    System.out.println(Arrays.toString(merged));