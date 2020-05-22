int[] array = {12, 23, -22, 0, 43, 545, -4, -55, 43, 12, 0, -999, -87};

for (int i = 0; i < array.length - 1; i++) {
    int count = 1;
    for (int j = i + 1; j < array.length; j++) {
        if (array[i] == array[j]) {
            count++;
        }
    }
    if (count > 1) {
        System.out.println(array[i] + "\toccurs\t" + count + " times");
    }
}