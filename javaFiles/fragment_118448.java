int j = 0;
while (j < result_array.length) {
    if (item.equals(" ")) {
        result_array[j] = "%";
        result_array[j + 1] = "2";
        result_array[j + 2] = "0";
        j = j + 2;
    } else
        result_array[j] = item;
    j++;
}