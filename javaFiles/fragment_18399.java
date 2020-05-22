int i = 0;
int arr[] = {0, 3, 7, -12, 8, -1, 0,  6, -6, 5, -2, 0, -1, 0};

int j = arr.length - 1;
while (true) {
    if (arr[i] >= 0) {
        ++i;
    }
    if (arr[j] < 0) {
        --j;
    }

    if (i > j)
        break;
    if (arr[i] < 0 && arr[j] >= 0) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

// The second part for positives and 0-s, starting for [0, j] (j is not changed)
i = 0;

while (true) {
    if (arr[i] > 0) {
        ++i;
    }
    if (arr[j] == 0) {
        --j;
    }

    if (i > j)
        break;

    if (arr[i] == 0 && arr[j] > 0) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

for (int anArr : arr) {
    System.out.print(anArr + ", ");
}