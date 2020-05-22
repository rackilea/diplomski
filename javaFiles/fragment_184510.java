private double average(int[] data) {
    int sum = 0;
    for (int i = 0; i < data.length; i++) {
        sum += data[i]; // here if you want a sum it's += not =
    }
    return (1.0 * sum) / data.length; // you want a double division, local "average" was useless
}