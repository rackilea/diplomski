Node pivot = findByIndex((low + high) / 2);
    int pivotData = pivot.data;
    int x = low, y = high;

    while (x <= y) {
        while (findByIndex(x).data < pivotData) {
            x++;
        }

        while (findByIndex(y).data > pivotData) {
            y--;
        }