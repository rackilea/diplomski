private int maxRow(int current_index, int max_index) {
    if (current_index == _mat.length) {
        return max_index;
    } else if (sumRow(current_index) > sumRow(max_index)) {
        return maxRow(current_index+1, current_index);
    } else {
        return maxRow(current_index+1, max_index);
    }
}

maxRow(1, 0); //method call