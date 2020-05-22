// value to keep track of the last row
long[][] values = {{1}};
System.out.println("[1]");
IntStream.range(1, 66).mapToObj($ -> {
    // next row has one more number
    long[] next = new long[values[0].length + 1];
    // it starts and ends with a 1
    next[0] = next[next.length - 1] = 1;
    // calculate all the numbers in between
    IntStream.range(1, values[0].length)
            .forEach(i -> next[i] = values[0][i] + values[0][i - 1]);
    // save it for next time and turn it into a String
    return Arrays.toString(values[0] = next);
}).forEach(System.out::println);