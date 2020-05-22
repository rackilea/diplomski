int[] array1 = {1,2,3,4,5};
int[] array2 = new int[array1.length];

int j = 0;

for (int value : array1) {
    if (approved(value)) {
        array2[j++] = value;
    }
}