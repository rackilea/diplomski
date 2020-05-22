int previous = array[0];
for (int i = 0; i < array.length - 1; i++) {
    int res = Math.min(previous, array[i]);
    res = Math.min(res, array[i + 1]);
    previous = array[i];
    array[i] = res;
}
array[array.length - 1] = Math.min(previous, array[array.length - 1];