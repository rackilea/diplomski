public int nextAvaIndex() {
    int index = -1;
    if (indexused == arr.length || arr[indexused] != null) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {   // error
                index = i;
                break;
            }
        }
        return index;

    } else {
        return indexused;
    }