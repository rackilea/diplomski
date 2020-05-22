int [] encode(int [] subgroup) {
    long result = 0;
    for (int i = 0; i <= 20; i++) {
        if (i > 0) {
           result *= numberMap[i - 1];
        }
        result += subgroup[i];
    }
    return result;
}

int [] decode(long code) {
    int []result = new int[21];
    for (int i = 20; i >= 0; i++) {
       result[i] = code % numberMap[i];
       code /= numberMap;
    }
    return result
}