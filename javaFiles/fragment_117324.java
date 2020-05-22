String x_ify(String input) {
    String output = "";
    int start = 0;
    int count = 0;
    int nextL;
    while ((nextL = input.indexOf('L', start)) >= 0) {
        if (nextL > start) {
            output = output + input.substring(start, nextL);
        }
        ++count;
        for (int i = 0; i < count; ++i) {
            output = output + "x";
        }
        start = nextL + 1;
    }
    if (start < input.length()) {
        output += input.substring(start);
    }
    return output;
}