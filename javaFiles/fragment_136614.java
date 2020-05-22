int[][] array = new int[5][5];

int value = 1,  flag = 0;

for (int i = 0; i < 5; i++) {
    if (flag == 0) {
        for (int j = 0; j < 5; j++) {
            array[j][i] = value++;
        }
        flag = 1;
    } else {
        for (int j = 4; j >= 0; j--) {
            array[j][i] = value++;
        }
        flag = 0;
    }
}

for (int i = 0; i < 5; i++) {
    System.out.println(Arrays.toString(array[i]));
}