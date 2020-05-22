int i = 0;
while (i < result.length - 1) {
    if (result[i] > result[i+1]) {
        permute(result, i)
        i = 0;
    } else {
        i++;
    }
}