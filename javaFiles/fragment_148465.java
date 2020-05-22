int[] array1 = {12, 23, -22, 0, 43, 545, -4, -55, 43, 12, 0, -999, -87};
int[] result = new int[array1.length];

int value = 0;
for (int i = 0; i < array1.length; i++) {
    value = array1[i];
    if (value >= 0) {
        result[i] = 1;
    } else {
        result[i] = -1;
    }
}

for (int i = 0; i < array1.length; i++) {
    for (int j = i + 1; j < array1.length; j++) {
        if (array1[i] == array1[j]) {
            result[j] = 0;
        }
    }
}

System.out.print("\nPositive array: ");
for (int i = 0; i < result.length; i++) {
    if (result[i] == 1) {
        System.out.print(" " + array1[i]);
    }
}
System.out.print("\nNegative array: ");
for (int i = 0; i < result.length; i++) {
    if (result[i] == -1) {
        System.out.print(" " + array1[i]);
    }
}
System.out.print("\nDuplicate array: ");
for (int i = 0; i < result.length; i++) {
    if (result[i] == 0) {
        System.out.print(" " + array1[i]);
    }
}